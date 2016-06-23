package com.translator.elements;

import com.translator.onlinelibrary.GoogleTranslateView;
import com.translator.onlinelibrary.SDLTranslateView;
import com.translator.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TranslateTest extends TestBase {
//    private static final Logger LOGGER = LoggerFactory.getLogger(TranslateTest.class);

    @Test
    public void GoogleTranslate() {
        driver.get("https://translate.google.com/");
        String textToTranslate = "Buona sera";
        String expectedResult = "Good evening";
        GoogleTranslateView google = new GoogleTranslateView();

        String result = google.translate("Italiană", "Engleză", textToTranslate);
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void SDLTranslate() {
        driver.get("https://www.freetranslation.com/");
        String textToTranslate = "Buona sera";
        String expectedResult = "Good evening";
        SDLTranslateView sdl = new SDLTranslateView();

        String result = sdl.translate("Italian", "English", textToTranslate);
        Assert.assertEquals(result, expectedResult);
    }
}
