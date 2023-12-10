package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CsvFileParserDiffblueTest {
    /**
     * Method under test: default or parameterless constructor of
     * {@link CsvFileParser}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     CsvFileParser.output_records
        //     CsvFileParser.records

        new CsvFileParser();
    }

    /**
     * Method under test: {@link CsvFileParser#fetchRecords(String)}
     */
    @Test
    void testFetchRecords() {
        CsvFileParser csvFileParser = new CsvFileParser();
        csvFileParser.fetchRecords("foo.txt");
        assertEquals("Record,Invalid,InvalidCardNumber", csvFileParser.processEachRecord("Record"));
    }

    /**
     * Method under test: {@link CsvFileParser#processRecords(String)}
     */
    @Test
    void testProcessRecords() {
        CsvFileParser csvFileParser = new CsvFileParser();
        csvFileParser.processRecords("foo.txt");
        assertEquals("Record,Invalid,InvalidCardNumber", csvFileParser.processEachRecord("Record"));
    }

    /**
     * Method under test: {@link CsvFileParser#writeFile(String)}
     */
    @Test
    void testWriteFile() {
        CsvFileParser csvFileParser = new CsvFileParser();
        csvFileParser.writeFile("foo.txt");
        assertEquals("Record,Invalid,InvalidCardNumber", csvFileParser.processEachRecord("Record"));
    }

    /**
     * Method under test: {@link CsvFileParser#processEachRecord(String)}
     */
    @Test
    void testProcessEachRecord() {
        assertEquals("Record,Invalid,InvalidCardNumber", (new CsvFileParser()).processEachRecord("Record"));
        assertEquals(",Invalid,InvalidCardNumber", (new CsvFileParser()).processEachRecord(""));
    }

    /**
     * Method under test: {@link CsvFileParser#processEachRecord(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testProcessEachRecord2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at org.example.CsvFileParser.processEachRecord(CsvFileParser.java:87)
        //   See https://diff.blue/R013 to resolve this issue.

        (new CsvFileParser()).processEachRecord(",");
    }

    /**
     * Method under test: {@link CsvFileParser#processEachRecord(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testProcessEachRecord3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.split(String)" because "record" is null
        //       at org.example.CsvFileParser.processEachRecord(CsvFileParser.java:87)
        //   See https://diff.blue/R013 to resolve this issue.

        (new CsvFileParser()).processEachRecord(null);
    }
}
