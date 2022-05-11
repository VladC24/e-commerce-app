package client

import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import models.NewProduct
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import play.api.BuiltInComponentsFromContext
import play.core.server.Server
import play.api.routing.sird._
import play.api.mvc._
import play.api.test._

import scala.language.postfixOps
import play.api.routing.Router
import play.filters.HttpFiltersComponents

class ProductClientSpec extends AnyWordSpec with Matchers {

  "ProductClient" should {

    def withProductClient[T](block: ProductClient => T): T = {
      Server.withApplicationFromContext() { context =>
        new BuiltInComponentsFromContext(context) with HttpFiltersComponents {
          override def router: Router = Router.from {
            case GET(p"/products") =>
              Action { req =>
                Results.Ok.sendResource("products.json")(executionContext, fileMimeTypes)
              }
          }
        }.application
      } { implicit port =>
        WsTestClient.withClient { client =>
          block(new ProductClient(client, ""))
        }
      }
    }

    "get products" in {
      withProductClient { client =>
        val json = """[
                     |  {
                     |    "id": 1,
                     |    "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                     |    "price": 109.95,
                     |    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                     |    "category": "men's clothing",
                     |    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                     |    "rating": {
                     |      "rate": 3.9,
                     |      "count": 120
                     |    }
                     |  },
                     |  {
                     |    "id": 2,
                     |    "title": "Mens Casual Premium Slim Fit T-Shirts ",
                     |    "price": 22.3,
                     |    "description": "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
                     |    "category": "men's clothing",
                     |    "image": "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
                     |    "rating": {
                     |      "rate": 4.1,
                     |      "count": 259
                     |    }
                     |  }
                     |]""".stripMargin
        val parsedJson: Json = parse(json).getOrElse(io.circe.Json.Null)
        val convertedJson = parsedJson.as[List[NewProduct]].getOrElse(List.empty)
       client.getProducts shouldBe convertedJson
      }
    }
  }

}
