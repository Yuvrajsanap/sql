import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            String data = "Hello, FileOutputStream!";
            fos.write(data.getBytes());
            System.out.println("Data written to output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
