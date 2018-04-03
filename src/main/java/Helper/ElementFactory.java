package Helper;

import Model.*;

import org.apache.log4j.*;

public class ElementFactory {

    private static Logger log = Logger.getLogger(ElementFactory.class);

    public static MapElement createElement(String[] elementInfos){

        String elementType = elementInfos[0];
        String[] args = new String[elementInfos.length-1];
        System.arraycopy(elementInfos, 1, args, 0, elementInfos.length-1);

        MapElement newElement = null;

        try{

            switch(elementType) {
                case "C":
                    newElement = new Map(args);
                    break;

                case "M":
                    newElement = new Mountain(args);
                    break;

                case "T":
                    newElement = new Treasure(args);
                    break;

                case "A":
                    newElement = new Adventurer(args);
                    break;

                default:
                    System.out.println("The type : " + elementType + " doesn't exist");
                    log.info("Element type : " + elementType +" doesn't exist");
                    break;
            }

        } catch(Exception ex) {
            System.out.println("An exception occurs while creating a MapElement : " + elementType);
            log.info("An exception occurs while creating a MapElement : " + ex);
        }


        return newElement;
    }
}
