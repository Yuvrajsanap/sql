
//Check
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Question2 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("example.txt");
            System.out.println("File successfully opened.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
