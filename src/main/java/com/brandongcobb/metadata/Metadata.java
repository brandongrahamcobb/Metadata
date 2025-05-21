package com.brandongcobb.metadata;

import com.brandongcobb.metadata.*;
import java.util.List;
import java.util.Map;

public class Metadata {

    public static final MetadataType<String> STRING = new MetadataString();
    public static final MetadataType<Integer> INTEGER = new MetadataInteger();
    public static final MetadataType<Double> DOUBLE = new MetadataDouble();
    public static final MetadataType<Float> FLOAT = new MetadataFloat();
    public static final MetadataType<Boolean> BOOLEAN = new MetadataBoolean();
    public static final MetadataType<Map<String, Object>> MAP = new MetadataMap();
    public static final MetadataType<List<String>> LIST = new MetadataList(STRING);
}
