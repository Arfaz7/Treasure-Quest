package Model;

public class Mountain extends FixedElement {

    public Mountain() { }

    public Mountain(int yAxis, int xAxis) {
        super(yAxis, xAxis, "M", true);
    }

    public Mountain(String[] args) {
        this(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }

    public String toString() {
        return ("M\t");
    }

    public String displayElementState() {
        return ("M - " + this.getyAxis() + " - " + this.getxAxis());
    }
}
