package ar.edu.tadp.viajes

class Viaje(var origen: Direccion, var destino: Direccion, var usuario: Usuario) {
  var recorridoElegido: Recorrido = null

  def armarRecorrido(): Recorrido = {
    var mediosCercaOrigen: List[TransporteCerca] = ModuloTransporte.mediosTransporteCerca(origen)
    var mediosCercaDestino: List[TransporteCerca] = ModuloTransporte.mediosTransporteCerca(destino)
    var mediosPosibles: List[TransporteCerca] = chequearMedios(mediosCercaOrigen, mediosCercaDestino)
    var posiblesRecorridos: List[Recorrido] = List()
    var unRecorrido: List[Tramo] = null

    if (mediosPosibles.isEmpty) {
      posiblesRecorridos = buscarCombinacion(mediosCercaOrigen, mediosCercaDestino)
    } else {
      for (a <- mediosPosibles) {
        unRecorrido = List()
        unRecorrido = crearTramo(mediosCercaDestino, a) :: unRecorrido
        posiblesRecorridos = new Recorrido(unRecorrido) :: posiblesRecorridos
      }
    }

    if (posiblesRecorridos.isEmpty) { //Logica de combinacion
      recorridoElegido = null
    } else if (posiblesRecorridos.length == 1) {
      recorridoElegido = posiblesRecorridos.head
    } else {
      recorridoElegido = usuario.seleccionarRecorrido(origen, destino, posiblesRecorridos)
    }

    return recorridoElegido
  }

  private def buscarCombinacion(mediosCercaOrigen: List[TransporteCerca], mediosCercaDestino: List[TransporteCerca]): List[Recorrido] = {
    var direccionCombinacion: Direccion = null
    var recorridos: List[Recorrido] = List()
    var unRecorrido: List[Tramo] = List()
    var unTramo: Tramo = null
    var medioTransporteCerca: List[TransporteCerca] = null
    var transporteElegidoFiltrado: List[TransporteCerca] = null

    for (unMedioOrigen <- mediosCercaOrigen) {
      for (unMedioDestino <- mediosCercaDestino) {
        direccionCombinacion = ModuloTransporte.puedeCombinar(unMedioOrigen.transporte, unMedioDestino.transporte)

        if (direccionCombinacion != null) {
          unTramo = new Tramo(unMedioOrigen.transporte, unMedioOrigen.direccion, direccionCombinacion)
          unRecorrido = unTramo :: unRecorrido
          medioTransporteCerca = ModuloTransporte.mediosTransporteCerca(direccionCombinacion)
          transporteElegidoFiltrado = medioTransporteCerca.filter(p => p.transporte.esIgual(unMedioDestino.transporte))
          unTramo = new Tramo(transporteElegidoFiltrado.head.transporte, transporteElegidoFiltrado.head.direccion, unMedioDestino.direccion)
          unRecorrido = unTramo :: unRecorrido
          recorridos = new Recorrido(unRecorrido) :: recorridos
        }
      }
    }

    return recorridos
  }

  private def crearTramo(mediosCercaDestino: List[TransporteCerca], medioPosible: TransporteCerca): Tramo = {
    var transporteElegidoFiltrado: List[TransporteCerca] = mediosCercaDestino.filter(p => p.transporte.esIgual(medioPosible.transporte))
    var transporteElegido: TransporteCerca = transporteElegidoFiltrado.head

    return new Tramo(transporteElegido.transporte, medioPosible.direccion, transporteElegido.direccion)
  }

  def calcularCosto(): Double = {
    return usuario.calcularDescuento(recorridoElegido)
  }

  def calcularTiempo(): Double = {
    var tiempoTotal: Double = 0
    var distancia: Double = ModuloTransporte.distanciaPie(origen, recorridoElegido.tramos.head.origen)

    tiempoTotal = 2.5 * distancia / 100
    distancia = ModuloTransporte.distanciaPie(recorridoElegido.tramos.last.destino, destino)
    tiempoTotal = tiempoTotal + 2.5 * distancia / 100
    tiempoTotal = tiempoTotal + recorridoElegido.calcularTiempo()

    return tiempoTotal
  }

  /*
   * Chequea si algun transporte que se toma en el origen es el mismo que los que se indican en el destino.
   */
  private def chequearMedios(mediosOrigen: List[TransporteCerca], mediosDestino: List[TransporteCerca]): List[TransporteCerca] = {
    var mediosPosibles: List[TransporteCerca] = List()

    for (a <- mediosOrigen) {
      for (b <- mediosDestino) {
        if (a.transporte.esIgual(b.transporte)) {
          mediosPosibles = b :: mediosPosibles
        }
      }
    }

    return mediosPosibles
  }
}