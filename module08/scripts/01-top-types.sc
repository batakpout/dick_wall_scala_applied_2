val j1: Any = if(true) "" else ()
val j2: Any = if(true) "" //implicit Unit
val j3: AnyVal = if(true) 1 else ()
val j4: AnyVal = if(true) 1 //implicit Unit

val s: String = "hello"

val sa: Any = s
val sar: AnyRef = s

// Does not compile
// val sav: AnyVal = s

val i: Int = 10
//Int extends AnyVal, or Boxed Int // Scala no distinct between boxed, unboxed types

val ia: Any = i
//runtime still knows i is String or ia is String
//but compiler has lot that info and it thinks its Any
val iav: AnyVal = i

// Does not compile
 //val iar: AnyRef = i

ia.isInstanceOf[Int]
/*
 java.lang.ClassCastException:
 java.lang.Integer cannot be cast to java.lang.String
 ia.asInstanceOf[String]
*/

sa.isInstanceOf[String]
 //sa.asInstanceOf[Int] ClassCastException

"1a".hashCode()
"hashcode".##
"1a".##

val n: String  = null

n.isInstanceOf[String]

val n2: Null = null
//type Null cannot be used in a type pattern or isInstanceOf test
//n2.isInstanceOf[Null]
//isInstanceOf is a run time check

val lots: Any = 1000

 lots.isInstanceOf[AnyRef]
/*
isInstanceOf works only on objects,
so scala before failing for compile time error,
checks if any implicit conversion is possible,
so it is implicitly converted to RichInt

 */