package org.clibankinjava.customdatastructureandoperationsonthem;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class OperationsOnMap {

    private OperationsOnMap() {}


    @SuppressWarnings("unchecked")
    public static <K, T> Map<K, T> putObjectAttributes(T object) {
        Map<K, T> attributes = new LinkedHashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                attributes.put((K) field.getName(), (T) field.get(object));
            }
        } catch (IllegalAccessException e) {
            System.out.printf("%n%s", e);
        }

        return attributes;
    }
}
