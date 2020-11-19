package model.database;

import java.util.ArrayList;

public class DatabaseController {

    private FileReader fileReader;
    private Database database;

    public DatabaseController(FileReader fileReader, Database database){
        this.fileReader = fileReader;
        this.database = database;
    }

    public void readFileInToDatabase(String filePath){
        ArrayList<String> file = this.fileReader.readFile(filePath);

        for(String user: file){
            int endNameIndex = user.indexOf(",");
            String userName = user.substring(0,endNameIndex);
            String userData = user.substring(endNameIndex+1,(Integer)user.length());
            database.getDatabase().put(userName,userData);
        }

    }


}
