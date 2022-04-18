package front

import org.openqa.selenium.By

object Selectors {

    fun withClass(className: String): By {
        return By.cssSelector("[class*=$className]")
    }

}