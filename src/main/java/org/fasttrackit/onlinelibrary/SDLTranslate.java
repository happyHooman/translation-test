package org.fasttrackit.onlinelibrary;

import com.sdl.selenium.bootstrap.form.TextArea;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;
//import static org.fasttrackit.util.TestBase.driver;


public class SDLTranslate {

    private WebLocator openInputLanguageList = new WebLocator().setId("translation-source");
    private WebLocator selectInputLanguage = new WebLocator().setClasses("lang-elem").setText("Italian");
    private WebLocator openOutputLanguageList = new WebLocator().setId("translation-target");
    private WebLocator parent = new WebLocator().setId("target-language");
    private WebLocator selectOutputLanguage = new WebLocator(parent).setText("English").setClasses("lang-elem");
    private TextArea input = new TextArea().setId("source-text");
    private TextArea output = new TextArea().setId("translated-text");


    private void setup() {
//        TestBase.driver.get("https://www.freetranslation.com/");

        openInputLanguageList.click();
        selectInputLanguage.click();

        openOutputLanguageList.click();
        selectOutputLanguage.click();
    }

    public String translate(String textToTranslate) {
        setup();
        input.sendKeys(textToTranslate);
        Utils.sleep(3000);
        return output.getValue();
    }
}