import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamExample {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.dat"))) {
            dos.writeInt(42);
            dos.writeFloat(3.14f);
            dos.writeUTF("Hello, DataOutputStream!");
            System.out.println("Data written to data.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
