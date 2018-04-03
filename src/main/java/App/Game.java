package App;

import Helper.ElementFactory;
import Model.Adventurer;
import Model.Map;
import Model.MapElement;
import Model.Treasure;

import java.util.ArrayList;

public class Game {

    private Map map;
    private ArrayList<MapElement> mapElements;
    private ArrayList<Adventurer> adventurers;

    public Game() {

        this.mapElements = new ArrayList<>();
        this.adventurers = new ArrayList<>();
    }

    public MapElement getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public ArrayList<MapElement> getMapElements() {
        return mapElements;
    }

    public void setMapElements(ArrayList<MapElement> mapElements) {
        this.mapElements = mapElements;
    }

    public ArrayList<Adventurer> getAdventurers() {
        return adventurers;
    }

    public void setAdventurers(ArrayList<Adventurer> adventurers) {
        this.adventurers = adventurers;
    }

    public void init(ArrayList<String[]> elements) {

        for (String[] elem : elements) {

            MapElement newElem = ElementFactory.createElement(elem);;

            if(elem[0].equals("C")) {
                this.map = (Map)newElem;
            }

            else {
                if(elem[0].equals("A")) {
                    if(newElem.getxAxis() >=0 && newElem.getxAxis() <= this.map.getElements().length &&
                            newElem.getyAxis() >=0 && newElem.getyAxis() <= this.map.getElements()[0].length ){
                        this.adventurers.add((Adventurer)newElem);
                    }

                    else {
                        System.out.println("Adventurer : " + ((Adventurer) newElem).getName() + " position doesn't exist");
                        newElem = null;
                    }
                }

                this.mapElements.add(newElem);
            }
        }

        this.map.placeElements(this.mapElements);
    }

    public void play() {

        for(Adventurer adv : this.adventurers) {
            int oldYAxis = adv.getyAxis();
            int oldXAxis = adv.getxAxis();

            this.moveAdventurer(adv);

            this.map.getElements()[oldXAxis][oldYAxis] = null;
            this.map.getElements()[adv.getxAxis()][adv.getyAxis()] = adv;

        }
    }

    private void moveAdventurer(Adventurer adv) {

        char[] sequence = adv.getMovementSequence().toCharArray();

        for (int i = 0; i< adv.getMovementSequence().length(); i++) {

            switch(sequence[i]) {
                case 'A':
                    this.moveForward(adv);
                    break;

                case 'D':
                    this.rotate(adv, 1);
                    break;

                case 'G':
                    this.rotate(adv, -1);
                    break;

                default:
                    System.out.println("Unknown command : " + sequence[i] + " for the adventurer : " + adv.getName());
                    break;
            }
        }
    }

    private void moveForward(Adventurer adv){

        switch(adv.getOrientation()) {

            case 'N':
                validatePositionAndMove(adv, (new int[]{adv.getxAxis()-1, adv.getyAxis()}));
                break;

            case 'E':
                validatePositionAndMove(adv, (new int[]{adv.getxAxis(), adv.getyAxis()+1}));
                break;

            case 'S':
                validatePositionAndMove(adv, (new int[]{adv.getxAxis()+1, adv.getyAxis()}));
                break;

            case 'O':
                validatePositionAndMove(adv, (new int[]{adv.getxAxis(),adv.getyAxis()-1}));
                break;

            default:
                break;
        }
    }

    private void validatePositionAndMove(Adventurer adv, int[] newPos){

        if(newPos[0] >= 0 && newPos[0] < this.map.getElements().length && newPos[1] >= 0 && newPos[1] < this.map.getElements()[0].length) {
            if(this.map.getElements()[newPos[0]][newPos[1]] == null) {
                adv.getPath().add(newPos);
                adv.setyAxis(newPos[1]);
                adv.setxAxis(newPos[0]);
            }

            else if(this.map.getElements()[newPos[0]][newPos[1]].getIcon().equals("T")) {
                adv.getPath().add(newPos);
                adv.setyAxis(newPos[1]);
                adv.setxAxis(newPos[0]);
                adv.setNbTreasureFound(adv.getNbTreasureFound()+1);

                ((Treasure)this.map.getElements()[newPos[0]][newPos[1]]).setNbTreasures(
                        ((Treasure)this.map.getElements()[newPos[0]][newPos[1]]).getNbTreasures() -1
                );
            }
        }
    }

    private void rotate(Adventurer adv, int rotationSide) {
        int oldOrientation = Adventurer.INTORIENTATION.get(adv.getOrientation()+"");
        int newOrientation = (Adventurer.ORIENTATIONS.length + oldOrientation + rotationSide) % Adventurer.ORIENTATIONS.length;

        adv.setOrientation(Adventurer.ORIENTATIONS[newOrientation].charAt(0));
    }


}
