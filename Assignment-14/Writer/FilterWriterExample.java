import java.io.FilterWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class FilterWriterExample {
    public static void main(String[] args) {
        try (StringWriter sw = new StringWriter(); UpperCaseFilterWriter fw = new UpperCaseFilterWriter(sw)) {
            fw.write("Hello, FilterWriter!");
            String output = sw.toString();
            System.out.println("Data written: " + output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UpperCaseFilterWriter extends FilterWriter {
    protected UpperCaseFilterWriter(Writer out) {
        super(out);
    }

    @Override
    public void write(int c) throws IOException {
        super.write(Character.toUpperCase(c));
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = 0; i < len; i++) {
            cbuf[off + i] = Character.toUpperCase(cbuf[off + i]);
        }
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str.toUpperCase(), off, len);
    }
}
