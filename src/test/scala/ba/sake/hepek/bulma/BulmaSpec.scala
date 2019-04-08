package ba.sake.hepek.bulma

import ba.sake.hepek.bulma.component.BreadcrumbComponents
import ba.sake.hepek.html.structure.{ComponentSettings, Dependency, DependencyProvider, StaticPage}
import ba.sake.hepek.matchers.HepekMatchers
import org.scalatest.matchers.{MatchResult, Matcher}
import org.scalatest.{FlatSpec, Matchers}
import scalatags.Text
import scalatags.Text.all._

object BulmaPage extends BreadcrumbComponents {

  def simpleContent: Text.all.Frag =
    breadcrumb(
      div(
        p("This is a big paragraph of text")
      )
    )

  def centeredContent: Text.all.Frag =
    centeredBreadcrumb(
      div(
        p("This is a big paragraph of text")
      )
    )
}

class BulmaSpec extends FlatSpec with Matchers with HepekMatchers {
  "simple Breadcrumb" should "have class 'breadcrumb'" in {
    BulmaPage.simpleContent.toString shouldBe
      """<nav class="breadcrumb"><ul><li><div><p>This is a big paragraph of text</p></div></li></ul></nav>"""
  }

  "centered Breadcrumb" should "have class 'breadcrumb'" in {
    BulmaPage.centeredContent.toString shouldBe
      """<nav class="breadcrumb is-centered"><ul><li><div><p>This is a big paragraph of text</p></div></li></ul></nav>"""
  }

  //trait MySiteTemplate extends BootstrapStaticPage {
}
