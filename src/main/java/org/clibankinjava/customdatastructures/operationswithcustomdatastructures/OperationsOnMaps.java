package org.clibankinjava.customdatastructures.operationswithcustomdatastructures;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class OperationsOnMaps {
    private OperationsOnMaps() {}

    public static Map<String, Object> putObjectAttributes(Object object) {
        Map<String, Object> attributes = new LinkedHashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                attributes.put(field.getName(), field.get(object));
            }
        } catch (IllegalAccessException e) {
            System.out.printf("%n%s", e);
        }

        return attributes;
    }
}
