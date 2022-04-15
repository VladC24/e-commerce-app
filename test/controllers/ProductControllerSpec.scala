package controllers

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.{FakeRequest, Injecting}
import play.api.test.Helpers._
import services.ProductService

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class ProductControllerSpec extends AnyWordSpec with GuiceOneAppPerTest with Injecting with Matchers {

  "ProductController" should {

    "render the productList page from a new instance of controller" in {
      val productService = new ProductService
      val controller = new ProductController(productService, stubControllerComponents())
      val home = controller.index().apply(FakeRequest(GET, "/productList"))

      status(home) mustBe 200
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("Product List")
    }
  }

}
