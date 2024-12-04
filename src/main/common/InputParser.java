package main.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputParser {
    public ArrayList<String> fileContentByLine = new ArrayList<>();
    public InputParser(String filepath){
        try {
            File file = new File(filepath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                fileContentByLine.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found! "+ e);
        }
    }
}
