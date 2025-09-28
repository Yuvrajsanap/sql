import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceInputStreamExample {
    public static void main(String[] args) throws Exception {
        ByteArrayInputStream bais1 = new ByteArrayInputStream("Hello, ".getBytes());
        ByteArrayInputStream bais2 = new ByteArrayInputStream("world!".getBytes());

        SequenceInputStream sis = new SequenceInputStream(bais1, bais2);

        int data;
        while ((data = sis.read()) != -1) {
            System.out.print((char) data);
        }
    }
}
