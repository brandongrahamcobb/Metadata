package com.brandongcobb.metadata;

import java.util.Map;
import java.util.Objects;

public class MetadataMap<K, V> implements MetadataType<Map<K, V>> {
    private final MetadataType<K> keyType;
    private final MetadataType<V> valueType;

    public MetadataMap(MetadataType<K> keyType, MetadataType<V> valueType) {
        this.keyType = keyType;
        this.valueType = valueType;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Map<K, V>> getType() {
        return (Class<Map<K, V>>) (Class<?>) Map.class;
    }

    public MetadataType<K> getKeyType() {
        return keyType;
    }

    public MetadataType<V> getValueType() {
        return valueType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetadataMap)) return false;
        MetadataMap<?, ?> that = (MetadataMap<?, ?>) o;
        return Objects.equals(keyType, that.keyType) && Objects.equals(valueType, that.valueType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyType, valueType);
    }

    @Override
    public String toString() {
        return "MetadataMap<" + keyType + "," + valueType + ">";
    }
}
