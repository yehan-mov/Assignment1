# Java Assignment Programs

Hey everyone,

I've uploaded the Java programs we've been working on for our computer assignments. Feel free to use them for learning, revision, or checking your own solutions.

## Programs Included

* `buzzNumber.java`
* `Smallest.java`
* `secondSmallest.java`
* `Square.java`
* `Perimeter.asm`
* `Showroom.java`
* `sumOfThree`
* `Temperature.java`
* `Time.java`

## How to Run

Compile:

```bash
javac FileName.java
```

Run:

```bash
java FileName
```

Example:

```bash
javac Smallest.java
java Smallest
```

## Important Notes

### Do NOT use these methods in your submission unless the teacher specifically allows them:

```java
public static void checkInt(Scanner scanner) {
    while (!scanner.hasNextInt()) {
        System.err.println("ERR: This field only accepts numbers. Please try again.");
        scanner.next();
    }
}
```

```java
public static void checkDouble(Scanner scanner) {
    while (!scanner.hasNextDouble()) {
        System.err.println("ERR: This field only accepts numbers. Please try again.");
        scanner.next();
    }
}
```

These methods were added for input validation and are not part of the actual assignment requirements.

### Please don't copy-paste the programs line by line.

The teacher may notice if multiple submissions are identical. It's better to understand the logic, write the code in your own style, rename variables if needed, and make small changes so that your work reflects your own understanding.

Use these programs as a reference, not as a direct submission.

## Requirements

* Java JDK 8 or later
* Any Java IDE (BlueJ, IntelliJ IDEA, Eclipse, NetBeans, VS Code, etc.)

Good luck, and I hope these help!

- Yehan
