package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AmericanExpressCardDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AmericanExpressCard#AmericanExpressCard(String)}
     *   <li>{@link AmericanExpressCard#getCardNum()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("42", (new AmericanExpressCard("42")).getCardNum());
    }

    /**
     * Method under test: {@link AmericanExpressCard#validateCardType(String)}
     */
    @Test
    void testValidateCardType() {
        assertEquals("Invalid: card number length wrong", (new AmericanExpressCard("42")).validateCardType("42"));
        assertEquals("Invalid: empty/null card number", (new AmericanExpressCard("42")).validateCardType((String) ""));
        assertEquals("Invalid: non numeric characters",
                (new AmericanExpressCard("42")).validateCardType("Invalid: card number length wrong"));
    }
}
