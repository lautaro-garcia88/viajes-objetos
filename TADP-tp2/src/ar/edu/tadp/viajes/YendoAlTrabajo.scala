package ar.edu.tadp.viajes

class YendoAlTrabajo extends Descuento {
  override def calcularDescuento(unRecorrido: Recorrido): Double = {
    var tarifaFinal: Double = unRecorrido.calcularCosto()

    if (unRecorrido.estaEnZonaTrabajo) tarifaFinal = tarifaFinal - 1.5

    return tarifaFinal
  }
}