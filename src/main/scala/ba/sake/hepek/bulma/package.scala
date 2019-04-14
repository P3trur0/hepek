package ba.sake.hepek.bulma

import scalatags.Text
import scalatags.Text.all._

package object component {

  sealed abstract class BulmaModifier(val classname: String)

  case object EmptyAttribute extends BulmaModifier("")
  case object Centered       extends BulmaModifier("is-centered")
  case object Left           extends BulmaModifier("is-left")
  case object Right          extends BulmaModifier("is-right")

  case object Small  extends BulmaModifier("is-small")
  case object Medium extends BulmaModifier("is-medium")
  case object Large  extends BulmaModifier("is-large")

  case object Toggle extends BulmaModifier("is-toggle")
  case object Boxed  extends BulmaModifier("is-boxed")

  case object PrimaryColor extends BulmaModifier("is-primary")
  case object LinkColor    extends BulmaModifier("is-link")
  case object InfoColor    extends BulmaModifier("is-info")
  case object SuccessColor extends BulmaModifier("is-success")
  case object WarningColor extends BulmaModifier("is-warning")
  case object DangerColor  extends BulmaModifier("is-danger")

  case object Outlined extends BulmaModifier("is-outlined")
  case object Loading  extends BulmaModifier("is-loading")

  case object ClearFix     extends BulmaModifier("is-clearfix")
  case object PulledLeft   extends BulmaModifier("is-pulled-left")
  case object PulledRight  extends BulmaModifier("is-pulled-right")
  case object Marginless   extends BulmaModifier("is-marginless")
  case object Paddingless  extends BulmaModifier("is-paddingless")
  case object Overlay      extends BulmaModifier("is-overlay")
  case object Clipped      extends BulmaModifier("is-clipped")
  case object Radiusless   extends BulmaModifier("is-radiusless")
  case object Shadowless   extends BulmaModifier("is-shadowless")
  case object Unselectable extends BulmaModifier("is-unselectable")
  case object Invisible    extends BulmaModifier("is-invisible")
  case object SrOnly       extends BulmaModifier("is-sr-only")

  case object Active extends BulmaModifier("is-active")

  def cssClasses(attributes: Seq[BulmaModifier]): String = {
    val classes = attributes
      .foldLeft("")((str, attribute) => s"$str ${attribute.classname}")
    if (classes.equals(" "))
      ""
    else
      classes
  }

  trait BulmaElement {
    def content: Frag
  }

  def optionalElementContent(opt: Option[BulmaElement]): Frag =
    opt.fold[Frag](SeqFrag[String](List()))(_.content)
}
