package Normaliser;

import com.testInterview.Normaliser.Normaliser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormaliserTest {
    private Normaliser normaliser;

    @BeforeEach
    void setUp() {
        normaliser = new Normaliser();
    }

    @Test
    void normaliseReturnsCorrectNormalizedTitle() {
        assertEquals("Software engineer", normaliser.normalise("Java engineer"));
        assertEquals("Software engineer", normaliser.normalise("C# Engineer"));
        assertEquals("Software engineer", normaliser.normalise("React Engineer"));
        assertEquals("Software engineer", normaliser.normalise("PHP Engineer"));
    }

    @Test
    void normaliseReturnsCorrectNormalizedTitleForDifferentCase() {
        assertEquals("Software engineer", normaliser.normalise("JAVA ENGINEER"));
    }

    @Test
    void normaliseReturnsCorrectNormalizedTitleForExactMatch() {
        assertEquals("Accountant", normaliser.normalise("Accountant"));
    }

    @Test
    void normaliseReturnsCorrectNormalizedTitleForPartialMatch() {
        assertEquals("Accountant", normaliser.normalise("Chief Accountant"));
    }

    @Test
    void normaliseReturnsCorrectNormalizedTitleForTitleWithExtraSpaces() {
        assertEquals("Software engineer", normaliser.normalise("  Java   engineer  "));
    }

    @Test
    void normaliseReturnUnKnowJobTitle() {
        assertEquals("Unknown Job Title", normaliser.normalise("No Job"));
    }

    @Test
    void normaliseReturnsCorrectNormalizedTitleForTitleWithSpecialCharacters() {
        assertEquals("Software engineer", normaliser.normalise("Java@engineer#"));
    }

    @Test
    void normaliseReturnsCorrectNormalizedTitleForTitleWithNumbers() {
        assertEquals("Software engineer", normaliser.normalise("Java engineer 123"));
    }

    @Test
    void normaliseReturnsCorrectNormalizedTitleForTitleWithMixedCase() {
        assertEquals("Software engineer", normaliser.normalise("JaVa EnGiNeEr"));
    }
}