//namespace shorthand
package demo.food.domain.api {

  trait Dessert

  case class IceCream(flavor: String) extends Dessert

  case class Jello(color: String) extends Dessert

  class packageVisibilitu {
    println(packageObjectNoImportNeeded)
  }
}
//C# namespace style
package demo {
  package food {
    package domain {
      package api {
        case class Candy(flavor: String)
      }
    }
  }
}