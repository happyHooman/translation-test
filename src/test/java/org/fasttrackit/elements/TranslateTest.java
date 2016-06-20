package org.fasttrackit.elements;

import org.fasttrackit.onlinelibrary.GoogleTranslate;
import org.fasttrackit.onlinelibrary.SDLTranslate;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TranslateTest extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TranslateTest.class);

    @Test
    public void GoogleTranslate() {
        TestBase.driver.get("https://translate.google.com/");
        String textToTranslate = "Buona sera";
        String expectedResult = "Good evening";
        String result;
        GoogleTranslate google = new GoogleTranslate();

        result = google.translate(textToTranslate);
        LOGGER.info("'{}' => '{}' ", textToTranslate, result);
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void SDLTranslate() {
        TestBase.driver.get("https://www.freetranslation.com/");
        String textToTranslate = "Buona sera";
        String expectedResult = "Good evening";
        String result;
        SDLTranslate sdl = new SDLTranslate();

        result = sdl.translate(textToTranslate);
        LOGGER.info("'{}' => '{}' ", textToTranslate, result);
        Assert.assertEquals(result, expectedResult);
    }
}
