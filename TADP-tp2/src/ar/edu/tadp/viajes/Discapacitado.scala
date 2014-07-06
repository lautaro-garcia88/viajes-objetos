package ar.edu.tadp.viajes

class Discapacitado extends Descuento {
  override def calcularDescuento(unRecorrido: Recorrido): Double = {
    return 0
  }
}