
public class JavaBugFixing {
    public static void main(String[] args) {
        DataWriter writer = WriterFactory.getWriter("mysql");
        writer.write("Test data");
    }
}
