package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VisaDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Visa#Visa(String)}
     *   <li>{@link Visa#getCardNum()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("42", (new Visa("42")).getCardNum());
    }

    /**
     * Method under test: {@link Visa#validateCardType(String)}
     */
    @Test
    void testValidateCardType() {
        assertEquals("Invalid: card number length wrong", (new Visa("42")).validateCardType("42"));
        assertEquals("Invalid: empty/null card number", (new Visa("42")).validateCardType((String) ""));
        assertEquals("Invalid: non numeric characters",
                (new Visa("42")).validateCardType("Invalid: card number length wrong"));
    }
}
