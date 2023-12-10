package org.example;

import org.junit.jupiter.api.Test;

class FileContextDiffblueTest {
    /**
     * Method under test: {@link FileContext#parse(String, String)}
     */
    @Test
    void testParse() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     FileContext.fileParser

        (new FileContext()).parse("foo.txt", "foo.txt");
    }

    /**
     * Method under test: {@link FileContext#parse(String, String)}
     */
    @Test
    void testParse2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     FileContext.fileParser

        (new FileContext()).parse(".", "foo.txt");
    }

    /**
     * Method under test: {@link FileContext#parse(String, String)}
     */
    @Test
    void testParse3() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     FileContext.fileParser

        (new FileContext()).parse(".csv", ".csv");
    }

    /**
     * Method under test: {@link FileContext#parse(String, String)}
     */
    @Test
    void testParse4() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     FileContext.fileParser

        (new FileContext()).parse(".json", ".json");
    }

    /**
     * Method under test: {@link FileContext#parse(String, String)}
     */
    @Test
    void testParse5() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     FileContext.fileParser

        (new FileContext()).parse(".xml", ".xml");
    }
}
