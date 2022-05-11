package client

import io.circe.jawn.decode
import models.NewProduct
import play.api.libs.ws.WSClient
import io.circe.generic.auto._
import javax.inject.Inject
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import play.api.Configuration

class ProductClient @Inject()(ws: WSClient, config: Configuration) {

  def getProducts: List[NewProduct] = {
    val url = s"${config.get[String]("baseUrl")}/products"
    val request = ws.url(url)
    val response = request.get()
    val newProduct = response.map { x =>
      val result = x.body
      decode[List[NewProduct]](result).getOrElse(List.empty)
    }
    Await.result(newProduct, 2.seconds)
  }

}
