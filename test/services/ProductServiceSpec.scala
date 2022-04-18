package services

import client.ProductClient
import models.Product
import org.mockito.MockitoSugar
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper


class ProductServiceSpec extends AnyFlatSpec with Matchers with MockitoSugar {

  "ProductService" should
    "get the list of products" in {
      val productClient = mock[ProductClient]
      val productService = new ProductService(productClient)
      productService.getList shouldBe List(Product("Bike", 100, "Mountain bike with 24 gears", 50), Product("Car", 2000, "A powerful four door saloon", 10))
    }
}
