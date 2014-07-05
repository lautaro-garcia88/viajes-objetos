package ar.edu.tadp.viajes

class Tramo(var transporte: Transporte, var origen: Direccion, var destino: Direccion) {
  def calcularTiempo(): Double = {
    return transporte.calcularTiempo(origen, destino)
  }
}