package ar.edu.tadp.viajes

abstract class Criterio {
  def seleccionarRecorrido(origen: Direccion, destino: Direccion, recorridos: List[Recorrido], unUsuario: Usuario): Recorrido
}