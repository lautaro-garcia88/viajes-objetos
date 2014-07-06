package ar.edu.tadp.viajes

class Recorrido(var tramos: List[Tramo]) {
  def calcularTiempo(): Double = {
    var tiempoTotal: Double = 0

    for (unTramo <- tramos) {
      tiempoTotal = tiempoTotal + unTramo.calcularTiempo()
    }

    if (!tramos.head.transporte.esIgual(tramos.last.transporte)) {
      tiempoTotal = tiempoTotal + tramos.head.transporte.calcularTiempoCombinacion(tramos.head.destino, tramos.last.origen, tramos.last.transporte)
    }

    return tiempoTotal
  }

  def calcularCosto(): Double = {
    var costo: Double = 0

    if (tramos.length > 1) {
      if (tramos.head.transporte.isInstanceOf[Subte] && tramos.last.transporte.isInstanceOf[Subte]) {
        costo = tramos.head.calcularCosto()
      }
    }

    if (costo == 0) {
      for (unTramo <- tramos) {
        costo = costo + unTramo.calcularCosto()
      }
    }

    return costo
  }

  def estaEnZonaTurismo(): Boolean = {
    //el viaje o el tramo completo se encuentra dentro de una zona determinada
    //(origen y destino estan en esa zona), o si solo un tramo se encuentra dentro de dicha zona.
    return (tramos.head.origen.esZonaTurismo || tramos.last.destino.esZonaTurismo)
  }

  def estaEnZonaTrabajo(): Boolean = {
    //Liniers o la Boca a la zona Centro
    return (tramos.head.origen.barrio == "La Boca" || tramos.head.origen.barrio == "Liniers") && tramos.last.destino.barrio == "Centro"
  }
}