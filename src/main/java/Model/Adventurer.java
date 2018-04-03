package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Adventurer extends MapElement {

    public static final String[] ORIENTATIONS = new String[]{"N","E","S","O"};

    public static final HashMap<String,Integer> INTORIENTATION = new HashMap<>();
    static{
        INTORIENTATION.put("N", 0);
        INTORIENTATION.put("E", 1);
        INTORIENTATION.put("S", 2);
        INTORIENTATION.put("O", 3);
    }

    private String name;
    private char orientation;
    private String movementSequence;
    private int nbTreasureFound;
    private ArrayList<int[]> path;

    public Adventurer() {
    }

    public Adventurer(String name, int yAxis, int xAxis, char orientation, String movementSequence) {
        super(yAxis, xAxis, "A");
        this.name = name.substring(0,3);
        this.orientation = orientation;
        this.movementSequence = movementSequence;
        this.path = new ArrayList<>();
        this.nbTreasureFound = 0;
    }

    public Adventurer(String[] args) {
        this(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3].charAt(0), args[4]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public int getNbTreasureFound() {
        return nbTreasureFound;
    }

    public void setNbTreasureFound(int nbTreasureFound) {
        this.nbTreasureFound = nbTreasureFound;
    }

    public String getMovementSequence() {
        return movementSequence;
    }

    public void setMovementSequence(String movementSequence) {
        this.movementSequence = movementSequence;
    }

    public ArrayList<int[]> getPath() {
        return path;
    }

    public void setPath(ArrayList<int[]> path) {
        this.path = path;
    }

    public String toString() {
        return ("A("+ this.name +")\t");
    }

    public String displayElementState() {
        return ("A - "+ this.name + " - " + this.getyAxis() + " - " + this.getxAxis() + " - " + this.orientation + " - " + this.nbTreasureFound );
    }
}
