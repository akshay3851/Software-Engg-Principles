# Liskov Substitution Principle (LSP)

The Liskov Substitution Principle (LSP) is one of the SOLID principles of object-oriented design. It states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. In other words, subclasses should be able to be substituted for their base classes without altering the expected behavior of the program.

## Why LSP Matters

LSP ensures that a subclass can stand in for its superclass without causing errors or unexpected behavior. This principle promotes the use of polymorphism and ensures that a derived class extends the functionality of the base class without changing its behavior.

## Example

### Without LSP

Consider a class hierarchy where a subclass violates LSP by not properly substituting the base class:

```java
/**
 * Rectangle class representing a rectangle.
 */
public class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }
}

/**
 * Square class representing a square.
 * Violates LSP because it alters the behavior of Rectangle.
 */
public class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Ensures width and height are the same
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // Ensures width and height are the same
    }
}

/**
 * Demonstrates LSP violation.
 */
public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.setWidth(5);
        rect.setHeight(10);
        System.out.println("Rectangle Area: " + rect.getArea()); // Outputs: 50

        Rectangle square = new Square();
        square.setWidth(5);
        System.out.println("Square Area: " + square.getArea()); // Outputs: 25, expected: 25
    }
}
```

### With LSP

Let's refactor the code to adhere to LSP by using composition instead of inheritance:

```java
/**
 * Interface representing a shape with an area.
 */
public interface Shape {
    int getArea();
}

/**
 * Rectangle class implementing Shape interface.
 */
public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

/**
 * Square class implementing Shape interface.
 */
public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

/**
 * Demonstrates LSP adherence.
 */
public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(5, 10);
        System.out.println("Rectangle Area: " + rect.getArea()); // Outputs: 50

        Shape square = new Square(5);
        System.out.println("Square Area: " + square.getArea()); // Outputs: 25
    }
}
```

## Explanation

- **Interface `Shape`**: Defines a contract for shapes to implement the `getArea()` method.
- **Class `Rectangle`**: Implements the `Shape` interface and calculates the area of a rectangle.
- **Class `Square`**: Implements the `Shape` interface and calculates the area of a square.
- **Main Class**: Demonstrates the usage of `Rectangle` and `Square` classes adhering to LSP.

### Key Points

- **LSP Violation**: In the first example, `Square` inherits from `Rectangle` and overrides methods in a way that changes the expected behavior, violating LSP.
- **LSP Adherence**: In the second example, `Square` and `Rectangle` both implement the `Shape` interface, ensuring that substituting one for the other does not alter the expected behavior of the program.

By following the Liskov Substitution Principle, we ensure that subclasses can replace their base classes without causing unexpected behavior, leading to more robust and maintainable code.

---