package App;

import Model.Adventurer;
import Model.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GameTest extends TestCase{

    /** * Create the test case * * @param testName name of the test case */
    public GameTest(String testName) {
        super(testName);
    }

    /** * @return the suite of tests being tested */
    public static Test suite() {
        return new TestSuite(GameTest.class);
    }

    /** * Rigourous Test :-) */
    public void testApp() {

        Adventurer newAdv = new Adventurer("Arfaz", 0,0, 'S' ,"D");
        Map map = new Map(3,4);

        Game game = new Game ();
        game.setMap(map);
        game.getAdventurers().add(newAdv);

        game.play();

        assertTrue((newAdv.getOrientation()+"").equals("O"));
    }

}
