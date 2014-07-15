package ar.edu.tadp.viajes

import scala.reflect.runtime.universe._
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF
import scala.reflect.ClassTag

class FiltroTipoTransporte[T <: Transporte: ClassTag] extends Filtro {
  def cumpleRequisito(unViaje: Viaje): Boolean = {

    var coincide = false
    for (tramo <- unViaje.recorridoElegido.tramos) {
      val value = tramo.transporte match {
        case _: T => true
        case _ => false
      }
      coincide ||= value
    }
    coincide
  }
}