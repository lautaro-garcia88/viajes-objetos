package ar.edu.tadp.viajes

class FiltroZona(var zonaTrabajo: Boolean, var zonaTurismo: Boolean) extends Filtro {
  def cumpleRequisito(unViaje: Viaje): Boolean = {
    return (unViaje.recorridoElegido.estaEnZonaTurismo && zonaTurismo) || (unViaje.recorridoElegido.estaEnZonaTrabajo && zonaTrabajo)
  }
}