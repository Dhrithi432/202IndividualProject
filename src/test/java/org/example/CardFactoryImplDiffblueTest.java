package org.example;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CardFactoryImplDiffblueTest {
    /**
     * Method under test: {@link CardFactoryImpl#createCard(String)}
     */
    @Test
    void testCreateCard() {
        assertNull((new CardFactoryImpl()).createCard("42"));
        assertNull((new CardFactoryImpl()).createCard((String) ""));
        assertNull((new CardFactoryImpl()).createCard("Card number"));
    }
}
