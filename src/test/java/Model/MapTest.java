package Model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MapTest extends TestCase{

    /** * Create the test case * * @param testName name of the test case */
    public MapTest(String testName) {
        super(testName);
    }

    /** * @return the suite of tests being tested */
    public static Test suite() {
        return new TestSuite(MapTest.class);
    }

    /** * Rigourous Test :-) */
    public void testApp() {

        Map m = new Map (3,4);
        assertEquals(4, m.getElements().length);
        assertEquals(3, m.getElements()[0].length);
    }

}
