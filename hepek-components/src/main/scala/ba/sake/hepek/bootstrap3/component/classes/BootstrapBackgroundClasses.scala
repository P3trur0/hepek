package ba.sake.hepek.bootstrap3.component.classes

import scalatags.Text.all._
import ba.sake.hepek.html.component.classes.BackgroundClasses

object BootstrapBackgroundClasses extends BootstrapBackgroundClasses

trait BootstrapBackgroundClasses extends BackgroundClasses {

  override def bgPrimary = cls := "bg-primary"
  override def bgSuccess = cls := "bg-success"
  override def bgInfo    = cls := "bg-info"
  override def bgWarning = cls := "bg-warning"
  override def bgDanger  = cls := "bg-danger"
}
