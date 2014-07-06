package ar.edu.tadp.viajes

class Turismo extends Descuento {
  override def calcularDescuento(unRecorrido: Recorrido): Double = {
    var tarifaFinal: Double = 0

    if (unRecorrido.estaEnZonaTurismo()) tarifaFinal = tarifaFinal * 0.9

    return tarifaFinal
  }
}