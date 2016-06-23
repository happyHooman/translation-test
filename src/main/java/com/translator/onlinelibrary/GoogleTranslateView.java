package com.translator.onlinelibrary;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GoogleTranslateView {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleTranslateView.class);


    private WebLocator openInputLanguageList = new WebLocator().setId("gt-sl-gms");
    private WebLocator inputLanguageParent = new WebLocator().setId("gt-sl-gms-menu");
    private WebLocator outputLanguageParent = new WebLocator().setId("gt-tl-gms-menu");
    private WebLocator openOutputLanguageList = new WebLocator().setId("gt-tl-gms");
    private WebLocator input = new WebLocator().setId("source");
    private WebLocator output = new WebLocator().setId("result_box");


    private void selectInputLanguage(String inputLanguage) {
        WebLocator selectInputLanguage = new WebLocator(inputLanguageParent).setText(inputLanguage);
        LOGGER.info(selectInputLanguage.getXPath());
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
        input.sendKeys(textToTranslate);
        Utils.sleep(1000);
        return output.getText();
    }

}