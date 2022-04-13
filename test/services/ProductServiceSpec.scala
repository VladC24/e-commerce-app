package services

import models.Product
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class ProductServiceSpec extends AnyFlatSpec with Matchers {

  "ProductService" should
    "get the list of products" in {
      val productService = new ProductService
      productService.getList shouldBe List(Product("bike", 100, "Red bike", 50), Product("car", 2000, "Nice car", 10))
    }

}
