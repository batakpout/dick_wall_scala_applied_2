abstract class Car {
  def color: String
  def describe: String = s"$color"
  override def toString = s"$describe car"
}

trait Classic extends Car {
  def vintage: Int
  override def describe: String =
    s"vintage $vintage ${super.describe}"
}

trait Convertible extends Car {
  override def describe: String =
    s"convertible ${super.describe}"
}

trait PoweredConvertible extends Convertible {
  override def describe: String =
    s"powered ${super.describe}"
}

trait HardtopConvertible extends Convertible {
  override def describe: String =
    s"hard-top ${super.describe}"
}

class ClassicConvertible1(val color: String, val vintage: Int)
  extends Car with PoweredConvertible with Classic with HardtopConvertible

abstract class Car {
  def color: String
  def describe: String = s"$color"
  override def toString = s"$describe car"
}

trait Classic extends Car {
  def vintage: Int
  override def describe: String =
    s"vintage $vintage ${super.describe}"
}

trait Convertible extends Car {
  override def describe: String =
    s"convertible ${super.describe}"
}

trait PoweredConvertible extends Convertible {
  override def describe: String =
    s"powered ${super.describe}"
}

trait HardtopConvertible extends Convertible {
  override def describe: String =
    s"hard-top ${super.describe}"
}
//Scala traits solves DAG(directed acyclic graph) problem
/*
 in this inheritance ,its figuring out one journey b/w all of these traits,
 that visits them all without violating any of the extension.
 -- every trait is called before its super trait
 */
class ClassicConvertible1(val color: String, val vintage: Int)
  extends Car with PoweredConvertible with Classic with HardtopConvertible

new ClassicConvertible1("red", 1965)

class ClassicConvertible2(val color: String, val vintage: Int)
  extends Car with Classic with PoweredConvertible with HardtopConvertible

new ClassicConvertible2("red", 1965)

class ClassicConvertible3(val color: String, val vintage: Int)
  extends Car with PoweredConvertible with HardtopConvertible with Classic

new ClassicConvertible3("red", 1965)


class ClassicCar(val color: String, val vintage: Int) extends Car with Classic
//construction composition
val ccc = new ClassicCar("red", 1965) with PoweredConvertible with HardtopConvertible //just in time

ccc.describe