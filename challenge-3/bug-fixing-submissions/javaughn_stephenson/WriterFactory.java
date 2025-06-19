public class WriterFactory {
    public static DataWriter getWriter(String type) {
        try {
            String className = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase() + "Writer";
            Class<?> clazz = Class.forName(className);
            return (DataWriter) clazz.getDeclaredConstructor().newInstance();
        }
        catch (NoClassDefFoundError e) {
            return tryNewName(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static DataWriter tryNewName(String name) {
        int length = name.length() - 1;
        int index = name.indexOf(":") + 2;
        String newClassName = name.substring(index,  length);
        try{
            Class<?> clazz = Class.forName(newClassName);
            return (DataWriter) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
