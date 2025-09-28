import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.IOException;

public class PipedWriterExample {
    public static void main(String[] args) {
        try (PipedWriter pw = new PipedWriter(); PipedReader pr = new PipedReader(pw)) {

            Thread writer = new Thread(() -> {
                try {
                    pw.write("Hello, PipedWriter!");
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread reader = new Thread(() -> {
                try {
                    int content;
                    while ((content = pr.read()) != -1) {
                        System.out.print((char) content);
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
