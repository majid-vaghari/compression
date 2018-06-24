# LZ77 Compression

This project is a basic implementation of LZ77 algorithm.

Designing Algorithms, Spring 2018, Sharif University of Technology.

# Usage

To use the `Encoder` inteface as a library:

```java
var message = "ababcabad";
var encoder = Encoder.create(10, 10);
System.out.println(encoder.encode(message));
// prints [0, 0]a[0, 0]b[0, 2][0, 0]c[0, 3][0, 0]d
```

To use as a CLI executable, enter window length and message length separated by a space in the first line and enter the message in the second line.

```
$ java -jar compression-1.0.1.jar
5 10
abcdeacdee

[0, 0]a[0, 0]b[0, 0]c[0, 0]d[0, 0]e[0, 1][2, 3][4, 1]
```

# Build

This project is bulit using [Gradle](https://gradle.org). Run `./gradlew tasks` to see available options.

You can run unit tests —written with JUnit, available in the test sources, if you run `./gradlew test`.

To check everything in the project and also run tests, run: `./gradlew check`.

To build the Jar file run `./gradlew jar`.

To generate Javadocs run `./gradlew javadoc`.

To build the whole project and also run tests and build Jar file, run `./gradlew build`.

When you run a task with Gradle, the output is stored in the `./build/` folder.

# External Links

More information about the algorithm can be found in the following links:
 - [The LZ77 Compression Family (Ep 2, Compressor Head)](https://youtu.be/Jqc418tQDkg)
 - [Elegant Compression in Text (The LZ 77 Method) - Computerphile](https://youtu.be/goOa3DGezUA)
 - [EXTRA BITS - Text Compression Meets Probabilities - Computerphile](https://youtu.be/cCDCfoHTsaU)
