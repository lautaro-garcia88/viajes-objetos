package ar.edu.tadp.viajes

class Consulta(var viajes: List[Viaje], var filtros: List[Filtro]) {
  def costoPromedioViajes(): Double = {
    var costoTotal: Double = 0

    for (unFiltro <- filtros) {
      viajes = aplicarFiltro(unFiltro)
    }

    for (unViaje <- viajes) {
      costoTotal = costoTotal + unViaje.calcularCosto()
    }

    return costoTotal / viajes.length
  }

  def tiempoPromedioViajes(): Double = {
    var tiempoTotal: Double = 0

    for (unViaje <- viajes) {
      tiempoTotal = tiempoTotal + unViaje.calcularTiempo()
    }
    return tiempoTotal / viajes.length
  }

  def porcentajeUtilizacion(): Double = {
    return viajes.length
  }

  def facturacionTotal(): Double = {
    var costoTotal: Double = 0

    for (unViaje <- viajes) {
      costoTotal = costoTotal + unViaje.calcularCosto()
    }

    return costoTotal
  }

  private def aplicarFiltro(unFiltro: Filtro): List[Viaje] = {
    var filtrados: List[Viaje] = List()

    for (unViaje <- viajes) {
      if (unFiltro.cumpleRequisito(unViaje)) filtrados = unViaje :: filtrados
    }

    return filtrados
  }
}