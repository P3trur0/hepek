package docs

import scalatags.Text.all._
import utils.Imports._

object CodeWalkthrough extends templates.HepekDocsPage {

  override def pageSettings =
    super.pageSettings
      .withTitle("Code walkthrough")
      .withDescription("Code walkthrough")

  override def blogSettings = super.blogSettings.withSections(
    contentsSection,
    templatesSection,
    importsSection
  )

  /* CONTENT */
  def contentsSection =
    Section(
      "Contents",
      """
        Content `object`s are usually placed in the `site` package.  
        This means they are rendered to the `/site` folder.  
        So, package is treated like a folder!

        File name is derived from `object`'s name, snake-cased, lowercased.  
        Also, some characters illegal for URLs are removed, for obvious reasons. :p  
        E.g. `object HelloWorld` will have name "hello-world.html" (default extension is "html").
      """.md
    )

  def templatesSection =
    Section(
      "Templates",
      """
        Template `trait`s are usually placed in the `templates` package.  
        You can put these *wherever you prefer*, only the content object packages matter.
      """.md
    )

  def importsSection =
    Section(
      "Common imports",
      """
        `Imports` object from `utils` package is recommended way for importing common components.  
        It's easier to change stuff just there, at one place.  
        E.g. if you want to change code highlight settings, you would override methods in `chl` object.
      """.md
    )
}
