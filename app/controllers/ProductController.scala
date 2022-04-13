package controllers

import play.api.mvc._
import services.ProductService
import javax.inject.{Inject, Singleton}

@Singleton
class ProductController @Inject()(productService: ProductService, val controllerComponents: ControllerComponents) extends BaseController{

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val products = productService.getList
    Ok(views.html.products.index(products))
  }
}


