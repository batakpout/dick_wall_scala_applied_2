class ShippingContainer[T] private /** [this] **/ (val items: Seq[T]) {
  private[this] val maxCount = 10
  private def isFull: Boolean = items.length >= maxCount

  override def toString: String = s"${ShippingContainer.containerColor} Container"
}

object ShippingContainer {

  def apply[T](items: T*) = new ShippingContainer[T](items)

  private def containerColor: String = "Green"

  // compile error, maxCount is private[this]
//  def maxItems(container: ShippingContainer[_]): Int =
//    container.maxCount

  def containerFull(container: ShippingContainer[_]): Boolean =
    container.isFull //companion can access private methods of class and vice versa
}

val sc = ShippingContainer("a", "b", "c")
sc.items
//sc.maxCount
//sc.isFull private
ShippingContainer.containerFull(sc)
