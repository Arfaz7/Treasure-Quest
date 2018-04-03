package App;

import Helper.FileReader;
import Helper.FileWriter;

import java.util.ArrayList;

public class MainApp {

    public static void main(String[] args) {

        if(args.length >= 2) {
            String inputFilePath = args[0];
            String outputFilePath = args[1];

            ArrayList<String[]> elementsInfos = FileReader.readFile(inputFilePath);

            Game game = new Game();

            game.init(elementsInfos);

            System.out.println("\nAfter importing information : \n");
            System.out.println(game.getMap());

            game.play();

            System.out.println("\nAfter playing game : \n");
            System.out.println(game.getMap());

            FileWriter.writeFile(game, outputFilePath);
        }

        else {
            System.out.println("Missing arguments. Please run this app as followed : java -jar treasure-quest.jar <inputFilePath> <outputFilePath>");
        }
    }
}
