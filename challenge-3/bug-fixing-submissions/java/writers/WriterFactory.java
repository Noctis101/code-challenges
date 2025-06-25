package writers;

import org.reflections.Reflections;

import java.util.Optional;
import java.util.Set;


public class WriterFactory {
    private final static String packageName = "writers.impl.";

    public static DataWriter getWriter(String type) {
        if (type != null) {
            try {
                String className = type + "Writer";
                Reflections reflections = new Reflections(packageName);
                Set<Class<? extends DataWriter>> subTypesOfClass = reflections.getSubTypesOf(DataWriter.class);
                Optional<Class<? extends DataWriter>> validClass = subTypesOfClass.stream()
                        .filter(aClass -> aClass.getSimpleName().equalsIgnoreCase(className))
                        .findFirst();
                if (validClass.isPresent()) {
                    Class<?> clazz = Class.forName(packageName + validClass.get().getSimpleName());
                    return (DataWriter) clazz.getDeclaredConstructor().newInstance();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
