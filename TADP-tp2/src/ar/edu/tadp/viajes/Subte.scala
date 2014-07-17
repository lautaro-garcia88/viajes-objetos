package ar.edu.tadp.viajes

class Subte(linea: String, compania: String) extends Transporte(linea, compania) {
  override def calcularTiempo(origen: Direccion, destino: Direccion): Double = {
    //TODO: preguntar por la forma correcta.
    var distancia: Double = ModuloTransporte.distanciaPie(origen, destino)

    return distancia / 400 * 3
  }

  override def calcularTarifa(origen: Direccion, destino: Direccion): Double = {
    return 4.5
  }

  override def calcularTiempoCombinacion(origen: Direccion, destino: Direccion, unTransporte: Transporte): Double = {
    var tiempo: Double = 0
    var distanciaEntreParadas: Double = 0

    if (unTransporte.isInstanceOf[Colectivo]) {
      distanciaEntreParadas = ModuloTransporte.distanciaPie(origen, destino)
      tiempo = 2.5 * distanciaEntreParadas / 100
    } else if (unTransporte.isInstanceOf[Subte]) {
      tiempo = 4
    } else if (unTransporte.isInstanceOf[Tren]) {
      tiempo = 5
    }

    return tiempo
  }

  override def unAbono(): Boolean = {
    return true
  }
}