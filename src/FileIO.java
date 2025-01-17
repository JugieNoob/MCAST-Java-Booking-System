import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileIO {
    
    public static String readTextFile(String filepath)
    {
        String finalString = "";
        String line = null;
        Path path = Paths.get(filepath);

        try
        {
            BufferedReader reader = null; //to read
            reader = Files.newBufferedReader(path);
            while((line = reader.readLine()) != null) //line is not empty
            {
                finalString += line + "\n";
            }
            reader.close();
        }

        catch (IOException io) 
        {
            System.out.println("Problem while reading file!");    
        }

        return finalString;
    }
    
    public static void appendToTextFile(String filePath, String toWrite)
    {
        /* This method takes a director and the string to be appended to the file as an input, by default the method creates a file if it doesn't exist 
        else if it exists it appends the string to the file. If any exception occurs user feedback is given*/
        toWrite = toWrite.replace("\n", "").replace("\r\n",""); //skips a line
        Path path = Paths.get(filePath);
        
        try
        {
            BufferedWriter writer = null;
            if(!Files.exists(path))
                writer = Files.newBufferedWriter(path , StandardOpenOption.CREATE); // creates new file if non existant
            else
            {
                writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND); //else appends to already existing file
                writer.write(toWrite);
                writer.newLine();
            }
            writer.close();
        }
        
        catch (IOException io)
        {
            System.out.println("Problem while writing to file");
        }
        
    }
    public static Boolean checkForData(String filepath)
    {
        String line = null;
        Boolean containsdata = true;
        Path path = Paths.get(filepath);

        try
        {
            BufferedReader reader = null; //to read
            reader = Files.newBufferedReader(path);
            if((line = reader.readLine()) == null) //line is empty
            {
                System.out.println("No data to read!");
                containsdata = false;
            }
            reader.close();
            
        }

        catch (IOException io) 
        {
            System.out.println("Problem while reading file!");    
        }
        return containsdata;
    }
    public static void main(String[] args) {
        //readTextFile("men.txt"); reading
        //appendToTextFile("men.txt", "hello how are you greg?"); writing
    }
}
