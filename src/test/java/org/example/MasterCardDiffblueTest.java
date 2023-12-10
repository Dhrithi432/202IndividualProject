package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MasterCardDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link MasterCard#MasterCard(String)}
     *   <li>{@link MasterCard#getCardNum()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("42", (new MasterCard("42")).getCardNum());
    }

    /**
     * Method under test: {@link MasterCard#validateCardType(String)}
     */
    @Test
    void testValidateCardType() {
        assertEquals("Invalid: card number length wrong", (new MasterCard("42")).validateCardType("42"));
        assertEquals("Invalid: empty/null card number", (new MasterCard("42")).validateCardType((String) ""));
        assertEquals("Invalid: non numeric characters",
                (new MasterCard("42")).validateCardType("Invalid: card number length wrong"));
    }
}
