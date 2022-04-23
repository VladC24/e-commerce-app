package services

import client.ProductClient
import models.{NewProduct, Product, Rating}
import org.mockito.MockitoSugar
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper


class ProductServiceSpec extends AnyFlatSpec with Matchers with MockitoSugar {

  "ProductService" should
    "get the list of products" in {
      val productClient = mock[ProductClient]
      val productService = new ProductService(productClient)
      val rating = Rating(2.22, 34)
      val productList = List(NewProduct(1, "Bike", 100, "Mountain bike with 24 gears", "Bikes", "image", rating))
      when(productClient.getProducts) thenReturn(productList)
      productService.getList shouldBe productList
    }
}
