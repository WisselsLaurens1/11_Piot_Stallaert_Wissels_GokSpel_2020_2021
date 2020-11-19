package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static void main(String[] args) {

    }


    public ArrayList<String> readFile(String path){
        ArrayList<String> file = new ArrayList<String>();

        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                file.add(data);
            }
            myReader.close();
            return file;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

        return file;
    }
}
