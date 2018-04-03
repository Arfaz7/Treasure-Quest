package Model;

public abstract class FixedElement extends MapElement {

    private boolean obstructed;

    public FixedElement() { }

    public FixedElement(int yAxis, int xAxis, String icon, boolean obstructed) {
        super(yAxis, xAxis, icon);
        this.obstructed = obstructed;
    }

    public FixedElement(String[] args) {
    }

    public boolean isObstructed() {
        return obstructed;
    }

    public void setObstructed(boolean obstructed) {
        this.obstructed = obstructed;
    }
}
