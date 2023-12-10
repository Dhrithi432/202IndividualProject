package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;

import org.json.simple.JSONArray;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;

class RecordsIteratorImplDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RecordsIteratorImpl#RecordsIteratorImpl(JSONArray, int)}
     *   <li>{@link RecordsIteratorImpl#next()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RecordsIteratorImpl actualRecordsIteratorImpl = new RecordsIteratorImpl(new JSONArray(), 3);
        actualRecordsIteratorImpl.next();
        assertFalse(actualRecordsIteratorImpl.isDone());
    }

    /**
     * Method under test: {@link RecordsIteratorImpl#RecordsIteratorImpl(List)}
     */
    @Test
    void testConstructor2() {
        assertTrue((new RecordsIteratorImpl(new ArrayList<>())).isDone());
    }

    /**
     * Method under test: {@link RecordsIteratorImpl#RecordsIteratorImpl(List)}
     */
    @Test
    void testConstructor3() {
        ArrayList<String> r = new ArrayList<>();
        r.add("foo");
        assertFalse((new RecordsIteratorImpl(r)).isDone());
    }

    /**
     * Method under test: {@link RecordsIteratorImpl#RecordsIteratorImpl(List)}
     */
    @Test
    void testConstructor4() {
        ArrayList<String> r = new ArrayList<>();
        r.add("42");
        r.add("foo");
        assertFalse((new RecordsIteratorImpl(r)).isDone());
    }

    /**
     * Method under test: {@link RecordsIteratorImpl#RecordsIteratorImpl(NodeList)}
     */
    @Test
    void testConstructor5() {
        assertTrue((new RecordsIteratorImpl(new IIOMetadataNode("foo"))).isDone());
    }

    /**
     * Method under test: {@link RecordsIteratorImpl#RecordsIteratorImpl(NodeList)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.w3c.dom.NodeList.getLength()" because "r" is null
        //       at org.example.RecordsIteratorImpl.<init>(RecordsIteratorImpl.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        new RecordsIteratorImpl((NodeList) null);
    }

    /**
     * Method under test: {@link RecordsIteratorImpl#currentString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCurrentString() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.base/java.util.Objects.checkIndex(Objects.java:359)
        //       at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //       at org.example.RecordsIteratorImpl.currentString(RecordsIteratorImpl.java:41)
        //   See https://diff.blue/R013 to resolve this issue.

        (new RecordsIteratorImpl(new ArrayList<>())).currentString();
    }

    /**
     * Method under test: {@link RecordsIteratorImpl#currentString()}
     */
    @Test
    void testCurrentString2() {
        ArrayList<String> r = new ArrayList<>();
        r.add("foo");
        assertEquals("foo", (new RecordsIteratorImpl(r)).currentString());
    }

    /**
     * Method under test: {@link RecordsIteratorImpl#currentNode()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCurrentNode() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.w3c.dom.NodeList.item(int)" because "this.xml_records" is null
        //       at org.example.RecordsIteratorImpl.currentNode(RecordsIteratorImpl.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        (new RecordsIteratorImpl(new ArrayList<>())).currentNode();
    }

    /**
     * Method under test: {@link RecordsIteratorImpl#currentNode()}
     */
    @Test
    void testCurrentNode2() {
        assertNull((new RecordsIteratorImpl(new IIOMetadataNode("foo"))).currentNode());
    }

    /**
     * Method under test: {@link RecordsIteratorImpl#currentObject()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCurrentObject() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.json.simple.JSONArray.get(int)" because "this.json_records" is null
        //       at org.example.RecordsIteratorImpl.currentObject(RecordsIteratorImpl.java:48)
        //   See https://diff.blue/R013 to resolve this issue.

        (new RecordsIteratorImpl(new ArrayList<>())).currentObject();
    }
}
