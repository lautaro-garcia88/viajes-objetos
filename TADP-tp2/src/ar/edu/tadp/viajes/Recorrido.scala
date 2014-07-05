package ar.edu.tadp.viajes

class Recorrido(var unRecorrido: List[Tramo]) {
  def calcularTiempo(): Double = {
    return 0
  }

  def calcularCosto(): Double = {
    return 0
  }

  def estaEnZonaTurismo(): Boolean = {
    return false
  }

  def estaEnZonaTrabajo(): Boolean = {
    return false
  }
}