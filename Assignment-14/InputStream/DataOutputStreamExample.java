import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamExample {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"))) {
            dos.writeBoolean(true);
            dos.writeChar('A');
            dos.writeDouble(123.456);
            dos.writeUTF("Hello, DataInputStream!");
            System.out.println("Data has been written to data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
