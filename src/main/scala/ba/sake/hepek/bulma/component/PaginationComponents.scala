package ba.sake.hepek.bulma.component

import scalatags.Text
import scalatags.Text.all._

object PaginationComponents extends PaginationComponents

sealed trait PaginationElement extends BulmaElement

case class Pagination(previous: Option[String], next: Option[String]) extends BulmaElement {
  override def content = frag(
    previous.fold[Frag](SeqFrag[String](List()))(a(cls := "pagination-previous")(_)),
    next.fold[Frag](SeqFrag[String](List()))(a(cls := "pagination-next")(_))
  )
}

case object PaginationEllipsis extends PaginationElement {
  override def content: Text.all.Frag = a(cls := "pagination-ellipsis")(raw("&hellip;"))
}

case class PaginationList(elements: Frag*) extends PaginationElement {
  override def content = ???
}

trait PaginationComponents {

  /*
  <nav class="pagination" role="navigation" aria-label="pagination">
   */

  def pagination =
    tag("nav")(cls := "pagination", role := "navigation", aria.label := "pagination")

}
