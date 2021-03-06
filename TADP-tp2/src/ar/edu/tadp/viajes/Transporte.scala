package ar.edu.tadp.viajes

abstract class Transporte(var linea: String, var compania: String) {
  def calcularTarifa(origen: Direccion, destino: Direccion): Double

  def calcularTiempo(origen: Direccion, destino: Direccion): Double

  def esIgual(unTransporte: Transporte): Boolean = {
    return unTransporte.linea == this.linea && unTransporte.compania == this.compania
  }

  def calcularTiempoCombinacion(origen: Direccion, destino: Direccion, unTransporte: Transporte): Double

  def unAbono(): Boolean = {
    return false
  }
}