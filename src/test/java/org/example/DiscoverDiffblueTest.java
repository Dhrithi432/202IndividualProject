package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DiscoverDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Discover#Discover(String)}
     *   <li>{@link Discover#getCardNum()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("42", (new Discover("42")).getCardNum());
    }

    /**
     * Method under test: {@link Discover#validateCardType(String)}
     */
    @Test
    void testValidateCardType() {
        assertEquals("Invalid: card number length wrong", (new Discover("42")).validateCardType("42"));
        assertEquals("Invalid: empty/null card number", (new Discover("42")).validateCardType((String) ""));
        assertEquals("Invalid: non numeric characters",
                (new Discover("42")).validateCardType("Invalid: card number length wrong"));
    }
}
