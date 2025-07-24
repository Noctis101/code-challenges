import writers.DataWriter;
import writers.WriterFactory;

public class JavaBugFixing {
    public static void main(String[] args) {
        DataWriter writer = WriterFactory.getWriter("example");
        writer.write("Test data");
    }
}
