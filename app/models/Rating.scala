package models

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

case class Rating(rate: Double, count: Int)

object Rating {
  implicit val fooDecoder: Decoder[Rating] = deriveDecoder
  implicit val fooEncoder: Encoder[Rating] = deriveEncoder
}
