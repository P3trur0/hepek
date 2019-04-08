package ba.sake.hepek.bulma.component

import scalatags.Text.all._

object DropdownComponents extends DropdownComponents

case class DropdownTrigger(triggerLabel: String) extends BulmaElement {
  override def content =
    div(cls := "dropdown-trigger")(
      button(cls := "button", aria.haspopup := true, aria.controls := "dropdown-menu")(
        span(triggerLabel),
        span(cls := "icon is-small")(
          i(cls := "fas fa-angle-down", aria.hidden := true)
        )
      )
    )
}

trait DropdownElement extends BulmaElement

case class DropdownItem(elements: Frag) extends DropdownElement {
  override def content = a(cls := "dropdown-item")(elements)
}

case class DropdownDivider(elements: Frag) extends DropdownElement {
  override def content = hr(cls := "dropdown-divider")
}

case class DropdownMenu(elements: DropdownElement*) extends BulmaElement {
  override def content = div(cls := "dropdown-menu", role := "menu")(
    div(cls := "dropdown-content")(for {
      elem <- elements
    } yield elem.content)
  )
}

trait DropdownComponents {

  def dropdown(trigger: Option[DropdownTrigger], menu: DropdownMenu) =
    div(cls := "dropdown")(
      optionalElementContent(trigger),
      menu.content
    )

  /*dropdown the main container
     dropdown-trigger the container for a button
     dropdown-menu the toggable menu, hidden by default
    dropdown-content the dropdown box, with a white background and a shadow
     dropdown-item each single item of the dropdown, which can either be a a or a div
    dropdown-divider a horizontal line to separate dropdown items */

  /*
  Card
  Dropdown
  Menu
  Message
  Modal
  Navbar
  Pagination
  Panel
  Tabs
 */
}
