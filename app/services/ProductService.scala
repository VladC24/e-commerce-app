package services

import client.ProductClient
import models.NewProduct

import javax.inject.Inject

class ProductService @Inject()(productClient: ProductClient){

  def getList: List[NewProduct] = {
    productClient.getProducts
  }
}


