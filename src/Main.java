import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        writeTextToFile("products.txt", "This is the 3rd  update at 2:00pm\n");

        StringBuilder output = readTextFile("products.txt");


    }

    public static void writeTextToFile(String fileName, String Input)    //method to write to file
    {
        Path filePath = Paths.get(fileName);      //will follow wherever main goes in directories
        // "../product.txt" for the file to be outside of main folder and one lvl up

        File productsFile = filePath.toFile();

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(productsFile, true));    //appends true will continue writting to file instead of starting new

            // PrintWriter out2 = new PrintWriter(productsFile);   //this will not append; it will delete old file and create new one

            out.print(Input);

            out.close();          //close file so it is available to others

        } catch (FileNotFoundException ex) {
            //ex.printStackTrace();
        }
    }


    public static StringBuilder readTextFile(String fileName) {
        Path filePath = Paths.get(fileName);

        File productsFile = filePath.toFile();

        StringBuilder result = new StringBuilder();

        try {
            FileReader r = new FileReader(productsFile);
            BufferedReader reader = new BufferedReader(r);

            String line = reader.readLine();
            while (line != null) {

                result.append(line + "\n");
                line = reader.readLine();
            }
            reader.close();
            return result;

        } catch (FileNotFoundException ex) {
            return null;

        } catch (IOException ex) {
            return null;

        }


    }


}
