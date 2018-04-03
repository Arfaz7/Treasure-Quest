package Model;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Map extends MapElement implements StateDisplayer {

    private static Logger log = Logger.getLogger(Map.class);

    private MapElement[][] elements;

    public Map() {
    }

    public Map(int yAxis, int xAxis) {
        super(yAxis, xAxis, "C");
        this.elements = new MapElement[this.getxAxis()][this.getyAxis()];
    }

    public Map(String[] args) {
        this(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }

    public MapElement[][] getElements() {
        return elements;
    }

    public void setElements(MapElement[][] elements) {
        this.elements = elements;
    }


    public void placeElements(ArrayList<MapElement> elements) {

        for (MapElement elem : elements) {

            if(elem != null) {
                if(this.elements[elem.getxAxis()][elem.getyAxis()] != null) {
                    int[] pos = this.findFreePlace();

                    System.out.println("Position : [" + elem.getyAxis() + ";" + elem.getxAxis() + "] already used.");
                    System.out.println("New free position found : [" + pos[1] + ";" + pos[0] + "]\n" );
                    elem.setyAxis(pos[1]);
                    elem.setxAxis(pos[0]);
                }

                this.elements[elem.getxAxis()][elem.getyAxis()] = elem;
            }
        }
    }

    private int[] findFreePlace(){
        int yAxis=-1, xAxis=-1;
        int j, i=0;

        while((i<this.elements.length) && (yAxis < 0 && xAxis < 0)) {
            j=0;

            while(j<this.elements[0].length && (yAxis < 0 && xAxis < 0)) {
                if(this.elements[i][j] == null) {
                    xAxis= i;
                    yAxis = j;
                }
                j++;
            }

            i++;
        }

        if(yAxis >= 0 && xAxis >= 0) {
            return (new int[]{xAxis, yAxis});
        }

        return null;
    }

    public String toString() {
        String mapPresentation = "\nMap View : \n";

        for (MapElement[] line : elements) {

            mapPresentation += "\n";

            for (MapElement elem : line) {
                if(elem == null) {
                    mapPresentation += ".\t\t";
                }

                else {
                    mapPresentation += elem.toString() + "\t";
                }
            }
        }

        return mapPresentation;
    }

    public String displayElementState() {
        return ("C - " + this.getyAxis() + " - " + this.getxAxis());
    }
}
