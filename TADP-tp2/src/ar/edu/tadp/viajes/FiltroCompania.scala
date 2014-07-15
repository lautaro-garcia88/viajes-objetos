package ar.edu.tadp.viajes

class FiltroCompania(var unaCompania: String) extends Filtro {
  def cumpleRequisito(unViaje: Viaje): Boolean = {
    return unViaje.recorridoElegido.tramos.head.transporte.compania == unaCompania || unViaje.recorridoElegido.tramos.last.transporte.compania == unaCompania
  }
}