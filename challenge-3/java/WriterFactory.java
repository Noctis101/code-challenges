
public class WriterFactory {
    public static DataWriter getWriter(String type) {
        try {
            String className = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase() + "Writer";
            Class<?> clazz = Class.forName("writers." + className);
            return (DataWriter) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
