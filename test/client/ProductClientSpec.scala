package client

import org.mockito.MockitoSugar.mock
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.Injecting

import scala.language.postfixOps

class ProductClientSpec extends AnyWordSpec with GuiceOneAppPerTest with Injecting with Matchers {

  "ProductClient" should {
    "not return null when doing a GET request" in {
      val productClient = mock[ProductClient]
      productClient.getProducts should not be null
    }
  }
}
