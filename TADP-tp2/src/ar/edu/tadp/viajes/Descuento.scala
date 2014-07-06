package ar.edu.tadp.viajes

abstract class Descuento {
  def calcularDescuento(unRecorrido: Recorrido): Double
}