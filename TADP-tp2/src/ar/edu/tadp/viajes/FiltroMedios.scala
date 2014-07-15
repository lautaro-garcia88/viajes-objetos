package ar.edu.tadp.viajes

class FiltroMedios(var linea: String) extends Filtro {
  def cumpleRequisito(unViaje: Viaje): Boolean = {
    return unViaje.recorridoElegido.tramos.head.transporte.linea == linea || unViaje.recorridoElegido.tramos.last.transporte.linea == linea
  }
}