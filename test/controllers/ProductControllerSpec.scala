package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test.Helpers._
import play.api.test._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class ProductControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "ProductController GET" should {

    "render the productList page from a new instance of controller" in {
      val controller = new ProductController(stubControllerComponents())
      val home = controller.index().apply(FakeRequest(GET, "/productList"))

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Product List")
    }

//    "render the index page from the application" in {
//      val controller = inject[ProductController]
//      val home = controller.index().apply(FakeRequest(GET, "/"))
//
//      status(home) mustBe OK
//      contentType(home) mustBe Some("text/html")
//      contentAsString(home) must include ("Welcome to Play")
//    }
//
//    "render the index page from the router" in {
//      val request = FakeRequest(GET, "/")
//      val home = route(app, request).get
//
//      status(home) mustBe OK
//      contentType(home) mustBe Some("text/html")
//      contentAsString(home) must include ("Welcome to Play")
//    }
  }
}