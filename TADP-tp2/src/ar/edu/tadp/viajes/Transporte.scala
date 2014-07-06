package ar.edu.tadp.viajes

abstract class Transporte {
  def calcularTarifa(origen: Direccion, destino: Direccion): Double

  def calcularDistancia(origen: Direccion, destino: Direccion): Int = { return 0 }

  def calcularTiempo(origen: Direccion, destino: Direccion): Double

  def esIgual(unTransporte: Transporte): Boolean

  def calcularTiempoCombinacion(origen: Direccion, destino: Direccion, unTransporte: Transporte): Double
}