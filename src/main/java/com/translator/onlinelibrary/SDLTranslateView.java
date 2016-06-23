package com.translator.onlinelibrary;

import com.sdl.selenium.bootstrap.form.TextArea;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;


public class SDLTranslateView {

    private WebLocator openInputLanguageList = new WebLocator().setId("translation-source");
    private WebLocator inputLanguageParent = new WebLocator().setId("source-language");
//    private WebLocator selectInputLanguage = new WebLocator().setClasses("lang-elem").setText("Italian");
    private WebLocator openOutputLanguageList = new WebLocator().setId("translation-target");
    private WebLocator outputLanguageParent = new WebLocator().setId("target-language");
//    private WebLocator selectOutputLanguage = new WebLocator(outputLanguageParent).setText("English");
    private TextArea input = new TextArea().setId("source-text");
    private TextArea output = new TextArea().setId("translated-text");


    private void selectInputLanguage(String inputLanguage) {
        WebLocator selectInputLanguage = new WebLocator(inputLanguageParent).setText(inputLanguage);
        selectInputLanguage.click();
    }

    private void selectOutputLanguage(String outputLanguage) {
        WebLocator selectOutputLanguage = new WebLocator(outputLanguageParent).setText(outputLanguage);
        selectOutputLanguage.click();
    }

    private void setup(String inputLanguage, String outputLanguage) {

        openInputLanguageList.click();
        selectInputLanguage(inputLanguage);

        openOutputLanguageList.click();
        selectOutputLanguage(outputLanguage);
    }

    public String translate(String inputLanguage, String outputLanguage, String textToTranslate) {
        setup(inputLanguage, outputLanguage);
        input.setValue(textToTranslate);
        Utils.sleep(3000);
        return output.getValue();
    }
}