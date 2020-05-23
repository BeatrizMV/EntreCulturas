package others;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Helper {
    public final static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Field findFieldInTopParent(Class<?> clazz, String fieldName) {
        Class<?> current = clazz;
        do {
            try {
                return current.getDeclaredField(fieldName);
            } catch(Exception e) {}
        } while((current = current.getSuperclass()) != null);
        return null;
    }

    public static Method findMethodInTopParent(Class<?> clazz, String methodName, Class<?> fieldClass) {
        Class<?> current = clazz;
        do {
            try {
                return current.getDeclaredMethod(methodName, fieldClass);
            } catch(Exception e) {}
        } while((current = current.getSuperclass()) != null);
        return null;
    }
}
