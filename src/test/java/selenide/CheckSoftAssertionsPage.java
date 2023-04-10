package selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckSoftAssertionsPage {
    @Test
    void findExampleOnSoftAssertionsPage() {

        // открыть страницу selenide в github
        open("https://github.com/");
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        // перейти на страницу wiki проекта
        $("#wiki-tab").click();
        // проверить что страница soft assertions в наличии
        $("#wiki-body").shouldHave(text("Soft assertions"));
        // открыть страницу soft assertions
        $("#wiki-body").$(byText("Soft assertions")).click();
        // проверить что есть пример кода для junit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }

}
