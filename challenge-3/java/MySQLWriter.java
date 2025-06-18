
public class MySQLWriter implements DataWriter {
    public void write(String data) {
        System.out.println("Writing to MySQL: " + data);
    }
}