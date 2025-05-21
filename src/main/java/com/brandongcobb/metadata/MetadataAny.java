package com.brandongcobb.metadata;

public class MetadataAny implements MetadataType<Object> {
    
    @Override
    public Class<Object> getType() {
        return Object.class;
    }

    @Override
    public String toString() {
        return "ANY";
    }
    
    public Object serialize(Object value) {
        return value; // Pass-through
    }

    public Object deserialize(Object raw) {
        return raw; // Pass-through
    }

}
