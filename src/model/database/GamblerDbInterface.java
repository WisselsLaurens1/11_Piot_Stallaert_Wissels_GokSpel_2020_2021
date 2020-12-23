package model.database;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import model.Gambler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface GamblerDbInterface {
    HashMap<String, Gambler> getGamblerDb();
    void read() throws FileNotFoundException, IOException, BiffException;
    void write(ArrayList<Gambler> gamblers, String playerName, Double gamblingSaldo) throws BiffException, IOException, RowsExceededException, WriteException;
}
