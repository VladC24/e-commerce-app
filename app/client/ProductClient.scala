package client

import play.api.libs.ws.{WSClient, readableAsJson}

import javax.inject.Inject
import scala.concurrent._
import ExecutionContext.Implicits.global

class ProductClient @Inject()(ws: WSClient) {

  def getProducts: Future[Unit] = {
    val url = "https://fakestoreapi.com/products"
    val request = ws.url(url)
    val response = request.get()
    response.map { x =>
      x.body
    }
  }
}
