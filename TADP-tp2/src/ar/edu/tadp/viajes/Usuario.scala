package ar.edu.tadp.viajes

class Usuario(var descuento: Descuento, var criterio: Criterio) {
  def calcularDescuento(unRecorrido: Recorrido): Double = {
    return descuento.calcularDescuento(unRecorrido)
  }

  def seleccionarRecorrido(origen: Direccion, destino: Direccion, recorridos: List[Recorrido]): Recorrido = {
    return criterio.seleccionarRecorrido(origen, destino, recorridos, this)
  }
}