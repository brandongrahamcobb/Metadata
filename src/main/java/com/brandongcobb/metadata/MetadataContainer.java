/*  MetadataContainer.java The primary purpose of this container is to
 *  be an object which wraps MetadataKey and MetadataHolder into a metadata
 *  map of types: MetadataKey with an unknown type ? and MetadataHolder with an unknown type ?.
 *
 *  Copyright (C) 2025  github.com/brandongrahamcobb
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.brandongcobb.metadata;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

public class MetadataContainer {

    private final Map<MetadataKey<?>, MetadataHolder<?>> metadata = new HashMap<>();

    public <T> void put(MetadataKey<T> key, T value) {
        metadata.put(key, new MetadataHolder<>(key, value));
    }

    public <T> T get(MetadataKey<T> key) {
        MetadataHolder<T> holder = (MetadataHolder<T>) metadata.get(key);
        return holder != null ? holder.getValue() : null;
    }

    public boolean contains(MetadataKey<?> key) {
        return metadata.containsKey(key);
    }

    public Set<Map.Entry<MetadataKey<?>, Object>> entrySet() {
        Map<MetadataKey<?>, Object> unwrapped = new LinkedHashMap<>();
        for (Map.Entry<MetadataKey<?>, MetadataHolder<?>> entry : metadata.entrySet()) {
            unwrapped.put(entry.getKey(), entry.getValue().getValue());
        }
        return unwrapped.entrySet();
    }

    public Map<String, Object> toMap() {
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map.Entry<MetadataKey<?>, MetadataHolder<?>> entry : metadata.entrySet()) {
            result.put(entry.getKey().getName(), entry.getValue().getValue());
        }
        return result;
    }
}

