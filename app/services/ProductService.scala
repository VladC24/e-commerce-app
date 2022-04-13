package services

import models.Product
import javax.inject.Inject

class ProductService @Inject()(){

  def getList: List[Product] = List(Product("bike", 100, "Red bike", 50), Product("car", 2000, "Nice car", 10))
}

