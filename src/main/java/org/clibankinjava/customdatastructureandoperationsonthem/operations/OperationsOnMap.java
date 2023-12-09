package org.clibankinjava.customdatastructureandoperationsonthem.operations;

import org.clibankinjava.customdatastructureandoperationsonthem.datastructures.SortOrder;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    public static <K, T> Map<K, T> mapSort(Map<K, T> inputMap, Comparator<T> valueComparator,
                                           boolean key, SortOrder order) {
        if (key) {
            return (order == SortOrder.ASC) ?
                    new TreeMap<>(inputMap) : new TreeMap<>(inputMap).descendingMap();
        }

        Comparator<T> customComparator =
                (order == SortOrder.ASC) ? valueComparator : valueComparator.reversed();

        return inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(customComparator))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (x, y) -> y, LinkedHashMap::new));
    }
}
