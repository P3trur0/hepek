package ba.sake.hepek.bulma.component

import scalatags.Text
import scalatags.Text.all._
import ba.sake.hepek.bulma._

object PaginationComponents extends PaginationComponents

sealed trait PaginationElement extends BulmaElement

case class Pagination(previous: Option[String], next: Option[String]) extends BulmaElement {
  override def content = frag(
    previous.fold[Frag](SeqFrag[String](List()))(a(cls := "pagination-previous")(_)),
    next.fold[Frag](SeqFrag[String](List()))(a(cls := "pagination-next")(_))
  )
}

case object PaginationEllipsis extends PaginationElement {
  override def content = a(cls := "pagination-ellipsis")(raw("&hellip;"))
}

case class PaginationNumber(number: Integer, current: Option[Current]) extends PaginationElement {
  override def content =
    li(a(cls := s"pagination-link${optionalModifier(current)}", number.toString()))
}

case class PaginationList(elements: Seq[PaginationNumber]) extends PaginationElement {
  override def content = ul(cls := "pagination-list")(
    for {
      element <- elements
    } yield element.content
  )
}

trait PaginationComponents {

  def pagination(elements: PaginationElement*) =
    tag("nav")(cls := "pagination", role := "navigation", aria.label := "pagination")(
      for {
        element <- elements
      } yield element.content
    )

}
