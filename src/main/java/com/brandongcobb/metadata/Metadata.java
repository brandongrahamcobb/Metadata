

/**
 * The Metadata class provides static metadata types and utility methods for handling metadata 
 * in Java applications. This class aims to offer type-safe methods for creating and managing
 * key-value pairs and collections.
 */
package com.brandongcobb.metadata;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Metadata {

    /** Static metadata types */
    public static final MetadataType<String> STRING = new MetadataString();
    public static final MetadataType<Integer> INTEGER = new MetadataInteger();
    public static final MetadataType<Double> DOUBLE = new MetadataDouble();
    public static final MetadataType<Float> FLOAT = new MetadataFloat();
    public static final MetadataType<Long> LONG = new MetadataLong();
    public static final MetadataType<Boolean> BOOLEAN = new MetadataBoolean();
    public static final MetadataType<Object> ANY = new MetadataAny();
    public static final MetadataType<Map<String, Object>> MAP = new MetadataMap<>(STRING, ANY);
    public static final MetadataType<List<String>> LIST_STRING = new MetadataList<>(STRING);
    public static final MetadataType<List<Integer>> LIST_INTEGER = new MetadataList<>(INTEGER);
    public static final MetadataType<List<Boolean>> LIST_BOOLEAN = new MetadataList<>(BOOLEAN);
    public static final MetadataType<List<Map<String, Object>>> LIST_MAP = new MetadataList<>(MAP);
    public static final MetadataType<MetadataContainer> METADATA = new MetadataContainer();

    /**
     * Creates a map from a sequence of key-value pairs.
     * Ensures type-safety by using varargs and type parameters.
     *
     * @param entries An array of key-value pairs.
     * @param <K> The type of keys in the resulting map.
     * @param <V> The type of values in the resulting map.
     * @return A map containing the provided key-value pairs.
     * @throws IllegalArgumentException if the number of arguments is not even.
     */
    public static <K, V> Map<K, V> mapOf(Object... entries) {
        if (entries.length % 2 != 0) {
            throw new IllegalArgumentException("mapOf requires an even number of arguments (key-value pairs).") ;
        }

        Map<K, V> map = new LinkedHashMap<>();
        for (int i = 0; i < entries.length; i += 2) {
            @SuppressWarnings("unchecked")
            K key = (K) entries[i];
            @SuppressWarnings("unchecked")
            V value = (V) entries[i + 1];
            map.put(key, value);
        }
        return map;
    }

    /**
     * Creates a list from a series of items.
     *
     * @param items The items to be included in the list.
     * @param <T> The type of items in the list.
     * @return A list containing the provided items.
     */
    @SafeVarargs
    public static <T> List<T> listOf(T... items) {
        return Arrays.asList(items);
    }
}
