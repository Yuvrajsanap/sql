import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class FilterReaderExample {
    public static void main(String[] args) {
        try (Reader sr = new StringReader("Hello, FilterReader!");
                FilterReader fr = new UpperCaseFilterReader(sr)) {
            int content;
            while ((content = fr.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UpperCaseFilterReader extends FilterReader {
    protected UpperCaseFilterReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toUpperCase((char) c));
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int result = super.read(cbuf, off, len);
        for (int i = off; i < off + result; i++) {
            cbuf[i] = Character.toUpperCase(cbuf[i]);
        }
        return result;
    }
}
