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

To use as a CLI tool, enter window length and message length separated by a space in the first line and enter the message in the second line.

```
$ java -jar compression-1.0.0.jar
5 10
abcdeacdee

[0, 0]a[0, 0]b[0, 0]c[0, 0]d[0, 0]e[0, 1][2, 3][4, 1]
```

# External Links

More information about the algorithm can be found in the following links:
 - [The LZ77 Compression Family (Ep 2, Compressor Head)](https://youtu.be/Jqc418tQDkg)
 - [Elegant Compression in Text (The LZ 77 Method) - Computerphile](https://youtu.be/goOa3DGezUA)
 - [EXTRA BITS - Text Compression Meets Probabilities - Computerphile](https://youtu.be/cCDCfoHTsaU)
