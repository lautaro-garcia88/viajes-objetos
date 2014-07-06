package ar.edu.tadp.viajes

object MenorTiempo extends Criterio {
  override def seleccionarRecorrido(origen: Direccion, destino: Direccion, recorridos: List[Recorrido], unUsuario: Usuario): Recorrido = {
    var tiempoAnterior: Double = 0
    var tiempoActual: Double = 0
    var recorridoSeleccionado: Recorrido = null
    var first: Boolean = true

    for (unRecorrido <- recorridos) {
      if (first) {
        recorridoSeleccionado = unRecorrido
        first = false
      } else {
        tiempoActual = calcularTiempo(origen, destino, unRecorrido)
        tiempoAnterior = calcularTiempo(origen, destino, recorridoSeleccionado)

        if (tiempoActual < tiempoAnterior) {
          recorridoSeleccionado = unRecorrido
        }
      }
    }

    return recorridoSeleccionado
  }

  private def calcularTiempo(origen: Direccion, destino: Direccion, unRecorrido: Recorrido): Double = {
    var tiempoTotal: Double = ModuloTransporte.distanciaPie(origen, unRecorrido.tramos.head.origen)

    tiempoTotal = tiempoTotal + ModuloTransporte.distanciaPie(unRecorrido.tramos.last.destino, destino)
    tiempoTotal = tiempoTotal + unRecorrido.calcularTiempo()

    return tiempoTotal
  }
}