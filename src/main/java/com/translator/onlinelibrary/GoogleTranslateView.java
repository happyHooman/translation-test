package com.translator.onlinelibrary;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;

//import static org.fasttrackit.util.TestBase.driver;


public class GoogleTranslateView {

    private WebLocator openInputLanguageList = new WebLocator().setId("gt-sl-gms");
    private WebLocator selectInputLanguage = new WebLocator().setText("Italiană").setClasses("goog-menuitem-content");
    private WebLocator parent2 = new WebLocator().setId("gt-tl-gms-menu");
    private WebLocator openOutputLanguageList = new WebLocator().setId("gt-tl-gms");
    private WebLocator selectOutputLanguage = new WebLocator(parent2).setText("Engleză");
    private WebLocator input = new WebLocator().setId("source");
    private WebLocator output = new WebLocator().setId("result_box");


    private void setup() {
//        TestBase.driver.get("https://translate.google.com/");

        openInputLanguageList.click();
        selectInputLanguage.click();

        openOutputLanguageList.click();
        selectOutputLanguage.click();
    }


    public String translate(String textToTranslate) {
        setup();
        input.sendKeys(textToTranslate);
        Utils.sleep(1000);
        return output.getText();
    }

}