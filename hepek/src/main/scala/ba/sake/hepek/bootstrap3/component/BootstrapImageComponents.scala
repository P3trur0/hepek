package ba.sake.hepek.bootstrap3.component

import scalatags.Text.all.{caption => _, _}

object BootstrapImageComponents extends BootstrapImageComponents

trait BootstrapImageComponents {

  /** Renders a pretty image with optional caption text */
  def image(source: String, caption: String = "") =
    if (caption.trim.isEmpty) {
      img(src := source, cls := "img-responsive", alt := caption)
    } else {
      div(cls := "thumbnail")(
        img(src := source, cls := "img-responsive", alt := caption),
        div(cls := "caption text-center")(p(caption))
      )
    }

  /** Renders a pretty bootstrapy SVG image with optional caption text */
  def svg(source: String, caption: String = "") =
    if (caption.trim.isEmpty) {
      tag("object")(tpe := "image/svg+xml", cls := "embed-responsive-item", data := source)(
        "Problem with rendering SVG..."
      )
    } else {
      div(cls := "thumbnail")(
        tag("object")(tpe := "image/svg+xml", cls := "embed-responsive-item", data := source)(
          "Problem with rendering SVG..."
        ),
        div(cls := "caption text-center")(p(caption))
      )
    }
}
