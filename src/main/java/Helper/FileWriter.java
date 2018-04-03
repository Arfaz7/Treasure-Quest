package Helper;

import App.Game;
import Model.MapElement;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {

    private static Logger log = Logger.getLogger(FileWriter.class);

    public static void writeFile(Game game, String outputFilePath) {

        List<String> lines = new ArrayList<>();

        lines.add(game.getMap().displayElementState());

        for (MapElement elem : game.getMapElements()) {
            lines.add(elem.displayElementState());
        }

        lines.add(game.getMap().toString());

        Path file = Paths.get(outputFilePath);

        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println("An error occurs while creating output file");
            log.info("An error occurs while creating output file : " + e);
        }

    }
}
