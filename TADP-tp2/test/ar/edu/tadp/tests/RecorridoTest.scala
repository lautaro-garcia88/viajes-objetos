package ar.edu.tadp.tests

import org.junit.Before
import ar.edu.tadp.viajes.Usuario
import ar.edu.tadp.viajes.Discapacitado
import org.junit.Test
import org.junit.Assert
import ar.edu.tadp.viajes.MenorCosto
import ar.edu.tadp.viajes.ModuloTransporte
import ar.edu.tadp.viajes.Direccion
import ar.edu.tadp.viajes.Viaje
import ar.edu.tadp.viajes.Tramo
import ar.edu.tadp.viajes.Colectivo
import ar.edu.tadp.viajes.Subte
import ar.edu.tadp.viajes.Recorrido

class RecorridoTest {
  @Test
  def calcularCostoSubteTest() = {
    var tramos: List[Tramo] = List()
    var origen: Direccion = new Direccion("calle 1", 20, "barrio 1", false)
    var destino: Direccion = new Direccion("calle 2", 20, "barrio 2", false)
    var unTramo: Tramo = new Tramo(new Subte("A"), origen, destino)
    tramos = unTramo :: tramos
    unTramo = new Tramo(new Subte("B"), origen, destino)
    tramos = unTramo :: tramos
    var unRecorrido = new Recorrido(tramos)
    var costo: Double = unRecorrido.calcularCosto()
    Assert.assertEquals(4.5, costo)
    Assert.assertEquals(5, unRecorrido.calcularTiempo())
    Assert.assertEquals(true, unRecorrido.estaEnZonaTurismo())
    Assert.assertEquals(true, unRecorrido.estaEnZonaTrabajo())
  }

  @Test
  def calcularCostoDosTramosTest() = {
    var expected: Double = 5.0
    var tramos: List[Tramo] = List()
    var origen: Direccion = new Direccion("calle 1", 20, "barrio 1", false)
    var destino: Direccion = new Direccion("calle 2", 20, "barrio 2", false)
    var unTramo: Tramo = new Tramo(new Colectivo(6), origen, destino)
    tramos = unTramo :: tramos
    unTramo = new Tramo(new Colectivo(5), origen, destino)
    tramos = unTramo :: tramos
    var unRecorrido = new Recorrido(tramos)
    var actual: Double = unRecorrido.calcularCosto()

    Assert.assertEquals(expected, actual)
  }
}