//
//  MetadataBytes.swift
//  
//
//  Created by Brandon Cobb on 6/18/25.
//


package com.brandongcobb.metadata;

import java.util.Objects;

public class MetadataBytes implements MetadataType<byte[]> {

    @Override
    public Class<byte[]> getType() {
        return byte[].class;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MetadataBytes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(byte[].class);
    }
}
