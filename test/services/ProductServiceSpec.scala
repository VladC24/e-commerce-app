package services

import models.Product
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class ProductServiceSpec extends AnyFlatSpec with Matchers {

  "ProductService" should
    "get the list of products" in {
      val productService = new ProductService
      productService.getList shouldBe List(Product("Bike", 100, "Mountain bike with 24 gears", 50), Product("Car", 2000, "A powerful four door saloon", 10))
    }

}
