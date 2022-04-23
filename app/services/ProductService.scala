package services

import client.ProductClient
import io.circe
import models.{NewProduct, Product}

import javax.inject.Inject
import scala.concurrent.Future

class ProductService @Inject()(productClient: ProductClient){

  def getList = {
    productClient.getProducts
  }
}


