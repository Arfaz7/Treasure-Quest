package Model;

public abstract class MapElement implements StateDisplayer {

    private String icon;
    private int xAxis;
    private int yAxis;

    public MapElement() { }

    public MapElement(int yAxis, int xAxis, String icon) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.icon = icon;
    }

    public MapElement(String[] args) {
    }


    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public abstract String toString();
}
