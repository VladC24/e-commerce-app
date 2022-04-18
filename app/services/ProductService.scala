package services

import client.ProductClient
import models.Product
import javax.inject.Inject

class ProductService @Inject()(productClient: ProductClient){

  def getList: List[Product] = {
    productClient.getProducts
    List(Product("Bike", 100, "Mountain bike with 24 gears", 50), Product("Car", 2000, "A powerful four door saloon", 10))
  }
}


