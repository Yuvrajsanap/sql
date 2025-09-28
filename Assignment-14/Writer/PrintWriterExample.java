import java.io.PrintWriter;
import java.io.IOException;

public class PrintWriterExample {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter("output.txt")) {
            pw.println("Hello, PrintWriter!");
            pw.printf("This is a formatted number: %.2f", 123.456);
            System.out.println("Data written to output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
