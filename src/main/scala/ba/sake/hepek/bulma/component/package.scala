package ba.sake.hepek.bulma

import scalatags.Text
import scalatags.Text.all._

package object component {

  sealed abstract class AttributeClass(val classname: String)

  case object EmptyAttribute extends AttributeClass("")
  case object Centered       extends AttributeClass("is-centered")
  case object Left           extends AttributeClass("is-left")
  case object Right          extends AttributeClass("is-right")

  case object Small  extends AttributeClass("is-small")
  case object Medium extends AttributeClass("is-medium")
  case object Large  extends AttributeClass("is-large")

  case object Toggle extends AttributeClass("is-toggle")
  case object Boxed  extends AttributeClass("is-boxed")

  def cssClasses(attributes: Seq[AttributeClass]): String = {
    val classes = attributes
      .foldLeft("")((str, attribute) => s"$str ${attribute.classname}")
    if (classes.equals(" "))
      ""
    else
      classes
  }

  trait BulmaElement {
    def content: Text.TypedTag[String]
  }

  def getElementContent(opt: Option[BulmaElement]): Frag =
    opt.fold[Frag](SeqFrag[String](List()))(_.content)
}
