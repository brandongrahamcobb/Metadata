package com.brandongcobb.metadata;

import com.brandongcobb.metadata.*;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Metadata {

    public static final MetadataType<String> STRING = new MetadataString();
    public static final MetadataType<Integer> INTEGER = new MetadataInteger();
    public static final MetadataType<Double> DOUBLE = new MetadataDouble();
    public static final MetadataType<Float> FLOAT = new MetadataFloat();
    public static final MetadataType<Boolean> BOOLEAN = new MetadataBoolean();
    public static final MetadataType<Object> ANY = new MetadataAny();
    public static final MetadataType<Map<String, Object>> MAP = new MetadataMap<>(STRING, ANY);;
    public static final MetadataType<List<String>> LIST_STRING = new MetadataList<>(STRING);
    public static final MetadataType<List<Integer>> LIST_INTEGER = new MetadataList<>(INTEGER);
    public static final MetadataType<List<Boolean>> LIST_BOOLEAN = new MetadataList<>(BOOLEAN);
    
    
    public static <K, V> Map<K, V> mapOf(Object... entries) {
        if (entries.length % 2 != 0) {
            throw new IllegalArgumentException("mapOf requires an even number of arguments (key-value pairs).");
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
    
    @SafeVarargs
    public static <T> List<T> listOf(T... items) {
        return Arrays.asList(items);
    }
}
