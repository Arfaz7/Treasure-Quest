package Model;

public class Treasure extends FixedElement {

    private int nbTreasures;

    public Treasure() {
    }

    public Treasure(int yAxis, int xAxis, int nbTreasures) {
        super(yAxis, xAxis, "T", false);
        this.nbTreasures = nbTreasures;
    }

    public Treasure(String[] args) {
        this(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }

    public int getNbTreasures() {
        return nbTreasures;
    }

    public void setNbTreasures(int nbTreasures) {
        this.nbTreasures = nbTreasures;
    }

    public String toString() {
        return ("T(" + this.nbTreasures + ")\t");
    }

    public String displayElementState() {
        return ("T - " + this.getyAxis() + " - " + this.getxAxis() + " - " + this.nbTreasures);
    }
}
