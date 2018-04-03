package Helper;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {

    private static Logger log = Logger.getLogger(FileReader.class);

    public static ArrayList<String[]> readFile(String inputFilePath) {
        ArrayList<String[]> elements = new ArrayList<>();


        try(BufferedReader br = Files.newBufferedReader(Paths.get(inputFilePath))) {

            String line;

            while((line = br.readLine()) != null) {
                String[] infos = line.split("-");

                if(infos.length > 1) {
                    for(int i = 0; i < infos.length; i++) {
                        infos[i] = infos[i].toUpperCase().trim();
                    }

                    elements.add(infos);
                }

            }

        } catch (IOException e) {

            System.out.println("Input file not found ! Please create the input file, named : 'input.txt' in the input folder");
            log.info("Fail to find inout file");
        }

        return elements;
    }
}
