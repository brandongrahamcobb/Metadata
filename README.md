# Metadata Package

This package provides a set of classes and interfaces to manage, store, and interact with metadata within your application. It allows for flexible, typed key-value pair storage, ensuring type safety and easy retrieval of metadata.

---
![Metadata](resources/pictures/Metadata.svg)
---

## How It Works

Core Components:

• **MetadataKey\<T\>**: Represents a key with a specific name and type.  
• **MetadataType\<T\>**: Defines the data type for the metadata value; includes methods for codecs, renderers, and behavior.  
• **MetadataHolder\<T\>**: Encapsulates a key-value pair, where the value matches the type defined by the key.  
• **MetadataContainer**: A container class that holds multiple metadata entries; provides methods to add, retrieve, and check for metadata.

In addition, we provide a convenience class to expose common types:

```java
package com.brandongcobb.metadata;

import com.brandongcobb.metadata.*;
import java.util.List;
import java.util.Map;

public class Metadata {

    public static final MetadataType<Object> ANY = new MetadataAny();
    public static final MetadataType<Boolean> BOOLEAN = new MetadataBoolean();
    public static final MetadataType<byte[]> BYTES = new MetadataBytes();
    public static final MetadataType<Double> DOUBLE = new MetadataDouble();
    public static final MetadataType<Float> FLOAT = new MetadataFloat();
    public static final MetadataType<Integer> INTEGER = new MetadataInteger();
    public static final MetadataType<Long> LONG = new MetadataLong();
    public static final MetadataType<List<Boolean>> LIST_BOOLEAN = new MetadataList<>(BOOLEAN);
    public static final MetadataType<List<Integer>> LIST_INTEGER = new MetadataList<>(INTEGER);
    public static final MetadataType<List<Map<String, Object>>> LIST_MAP = new MetadataList<>(MAP);
    public static final MetadataType<List<String>> LIST_STRING = new MetadataList<>(STRING);
    public static final MetadataType<Map<String, Object>> MAP = new MetadataMap<>(STRING, ANY);
    public static final MetadataType<MetadataContainer> METADATA = new MetadataContainer();
    public static final MetadataType<String> STRING = new MetadataString();
}
```

Basic Usage:

1. Define keys with `MetadataKey<T>`, associating a name with a `MetadataType<T>`.  
2. Store data with `MetadataContainer.put()`.  
3. Retrieve data with `MetadataContainer.get()`.  
4. Type safety is enforced by the key’s `MetadataType<T>`.

---

## How to Add the Package as a Dependency

### 1. Build the Package

1. Download or clone the repository containing the metadata package.

Compile and package into a JAR. If your consuming project targets an older Java version, use --release:,

```bash
Compile against a specific Java release (e.g. Java 8),
javac --release 8 -d out/ src/main/java/com/brandongcobb/metadata/.java

Package classes into metadata-1.0.0.jar,
jar cf metadata-1.0.0.jar -C out/ main/
```

This ensures the bytecode is compatible with the specified target release.

Add the JAR to Your Project,
```bash
cp metadata-1.0.0.jar /path/to/your/project/lib

• Maven
Place metadata-1.0.0.jar under a lib/ directory in your project root.,
Install it into your local Maven repository:,

```bash
mvn install:install-file -Dfile=path/to/your/project/lib/metadata-1.0.0.jar -DgroupId=com.brandongcobb -DartifactId=metadata -Dversion=1.0.0 -Dpackaging=jar
```

Add to your pom.xml:,

```xml
<dependency>
    <groupId>com.brandongcobb</groupId>
    <artifactId>metadata</artifactId>
    <version>1.0.0</version>
</dependency>
```

• Gradle

```groovy
dependencies {
    implementation files('lib/metadata-1.0.0.jar')
}
```

• No build system
  Include metadata-1.0.0.jar on your classpath.

---

Use in Your Code,
Import the package:

```java
import com.brandongcobb.metadata.;
```

Create a container, define keys, and store/retrieve metadata:

```java
public class ExampleUsage {
    public static void main(String[] args) {
        MetadataContainer container = new MetadataContainer();

        // Define a key using the shared Metadata types
        MetadataKey<String> idKey = new MetadataKey<>("id", Metadata.STRING);

        // Store a value
        String requestId = "example-string";
        container.put(idKey, requestId);

        // Retrieve the value
        String retrieved = container.get(idKey);
        System.out.println("Request ID: " + retrieved);
    }
}
```

---
Example: Multiple Types,
```java
public class MixedMetadataExample {
    public static void main(String[] args) {
        MetadataContainer container = new MetadataContainer();

        MetadataKey<Integer> scoreKey     = new MetadataKey<>("score", Metadata.INTEGER);
        MetadataKey<Boolean> activeKey    = new MetadataKey<>("active", Metadata.BOOLEAN);
        MetadataKey<List<String>> tagsKey = new MetadataKey<>("tags", Metadata.LIST_STRING);

        container.put(scoreKey, 42);
        container.put(activeKey, true);
        container.put(tagsKey, List.of("alpha", "beta", "gamma"));

        System.out.println("Score: "  + container.get(scoreKey));
        System.out.println("Active: " + container.get(activeKey));
        System.out.println("Tags: "   + container.get(tagsKey));
    }
}
```

---

Summary,
This metadata package provides a flexible, type-safe approach to managing metadata within applications. By defining keys with specific types (exposed via the Metadata helper class), it reduces boilerplate and runtime errors.
