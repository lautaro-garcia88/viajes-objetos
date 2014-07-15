package ar.edu.tadp.viajes

abstract class Filtro() {
  def cumpleRequisito(unViaje: Viaje):Boolean
}