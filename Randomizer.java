package csu.csci325;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* @author Geoff Clark */

public class Randomizer {
   
   /* FILE_PATH should be based on selection of which file to use */
   private static final String FILE_PATH = "C:\\Temp\\Test.txt";
   public static void main(String args[]) throws IOException {
      FileReader fileRead = new FileReader(FILE_PATH);
      Random rand = new Random();
      int randPick = rand.nextInt((fileRead.getLineCount()) - 1);
      String phrase = Files.readAllLines(Paths.get(FILE_PATH)).get(randPick);
      /* The next line should be changed to store the phase instead of print */
      System.out.println(phrase);   
   }
}

class FileReader {
   static BufferedReader reader = null;    
   public FileReader(String filePath) throws FileNotFoundException {
      File file = new File(filePath);
      FileInputStream fileStream = new FileInputStream(file);
      InputStreamReader input = new InputStreamReader(fileStream);
      reader = new BufferedReader(input);
   }

   public static int getLineCount() throws IOException {
      int lineCount = 0;
      String data;        
      while((data = reader.readLine()) != null) {
         lineCount++;                  
      }            
      return lineCount;
   }
}