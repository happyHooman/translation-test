package com.translator.onlinelibrary;

import com.sdl.selenium.bootstrap.form.TextArea;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;


public class SDLTranslateView {

    private WebLocator openInputLanguageList = new WebLocator().setId("translation-source");
    private WebLocator selectInputLanguage = new WebLocator().setClasses("lang-elem").setText("Italian");
    private WebLocator openOutputLanguageList = new WebLocator().setId("translation-target");
    private WebLocator parent = new WebLocator().setId("target-language");
    private WebLocator selectOutputLanguage = new WebLocator(parent).setText("English");
    private TextArea input = new TextArea().setId("source-text");
    private TextArea output = new TextArea().setId("translated-text");


    private void setup() {

        openInputLanguageList.click();
        selectInputLanguage.click();

        openOutputLanguageList.click();
        selectOutputLanguage.click();
    }

    public String translate(String textToTranslate) {
        setup();
        input.setValue(textToTranslate);
        Utils.sleep(3000);
        return output.getValue();
    }
}