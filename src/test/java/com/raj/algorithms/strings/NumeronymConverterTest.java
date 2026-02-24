package com.raj.algorithms.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumeronymConverterTest {

    @Test
    void tokenConversion_basicExamples() {
        assertEquals("i18n", NumeronymConverter.toNumeronymToken("internationalization"));
        assertEquals("l10n", NumeronymConverter.toNumeronymToken("localization"));
        assertEquals("cat", NumeronymConverter.toNumeronymToken("cat"));
        assertEquals("a2d", NumeronymConverter.toNumeronymToken("abcd"));
    }

    @Test
    void textConversion_preservesPunctuationAndSpaces() {
        String input = "internationalization, localization! AI 2026.";
        String expected = "i18n, l10n! a0i 2046.";
        assertEquals(expected, NumeronymConverter.toNumeronymText(input));
    }

    @Test
    void allNumeronyms_containsCommonForm() {
        List<String> all = NumeronymConverter.allNumeronyms("localization");
        assertTrue(all.contains("l10n"));
    }

    @Test
    void nullInput_throws() {
        assertThrows(NullPointerException.class, () -> NumeronymConverter.toNumeronymToken(null));
        assertThrows(NullPointerException.class, () -> NumeronymConverter.toNumeronymText(null));
        assertThrows(NullPointerException.class, () -> NumeronymConverter.allNumeronyms(null));
    }
}
