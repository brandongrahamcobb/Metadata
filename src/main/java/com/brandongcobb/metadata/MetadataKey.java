/*  MetadataKey.java The primary purpose of this class is to
 *  be an object with a key whos name and type are known.
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

import java.util.Objects;

 public final class MetadataKey<T> {

    private final String name;
    private final MetadataType<?> type;

    public MetadataKey(String name, MetadataType<?> type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public MetadataType<?> getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetadataKey)) return false;
        MetadataKey<?> that = (MetadataKey<?>) o;
        return name.equals(that.name) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}
