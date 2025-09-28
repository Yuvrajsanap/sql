import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;

public class PipedOutputStreamExample {
    public static void main(String[] args) {
        try (PipedOutputStream pos = new PipedOutputStream();
                PipedInputStream pis = new PipedInputStream(pos)) {

            Thread writer = new Thread(() -> {
                try {
                    pos.write("Hello, PipedOutputStream!".getBytes());
                    pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread reader = new Thread(() -> {
                try {
                    int data;
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writer.start();
            reader.start();
            writer.join();
            reader.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
