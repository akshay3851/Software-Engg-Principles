# Open/Closed Principle (OCP)

The Open/Closed Principle (OCP) is one of the SOLID principles of object-oriented design. It states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

## Why OCP Matters

OCP encourages developers to design software modules that can be extended with new functionality without modifying existing code. This principle promotes code stability, reusability, and maintainability by allowing changes to be made by adding new code rather than changing existing code.

## Example

### Shape and Area Calculation Example

Consider a system that calculates the area of different shapes (e.g., rectangles, circles). Instead of modifying an existing area calculation method each time a new shape is introduced, we adhere to OCP by using abstraction and polymorphism:

```java
/**
 * Interface representing a Shape.
 */
public interface Shape {
    double calculateArea();
}

/**
 * Rectangle class implementing the Shape interface.
 */
public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

/**
 * Circle class implementing the Shape interface.
 */
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

/**
 * Utility class demonstrating how the area calculation can be extended without modifying existing code.
 */
public class AreaCalculator {
    /**
     * Calculates the total area of an array of shapes.
     * 
     * @param shapes array of shapes.
     * @return total area of all shapes.
     */
    public double calculateTotalArea(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}

/**
 * Main method demonstrating usage of the OpenClosedPrinciple classes.
 *
 */
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Rectangle(5, 10),
            new Circle(7)
        };

        AreaCalculator calculator = new AreaCalculator();
        double totalArea = calculator.calculateTotalArea(shapes);
        System.out.println("Total area of all shapes: " + totalArea);
    }
}
```

### Explanation:

- **Interface `Shape`**: Defines a contract for shapes to implement `calculateArea()`.

- **Classes `Rectangle` and `Circle`**: Implement the `Shape` interface and provide specific implementations for calculating area (`calculateArea()` method).

- **`AreaCalculator` Class**: Calculates the total area of an array of shapes without needing to know the specific shape implementations. It adheres to OCP by accepting any class that implements the `Shape` interface.

- **`Main` Class**: Demonstrates usage by creating instances of `Rectangle` and `Circle`, calculating their total area using `AreaCalculator`, and printing the result.

## Conclusion

By adhering to the **Open/Closed Principle**, we design software that is more *flexible* and *resilient* to change. We can introduce new functionality (new shapes) by extending existing code (implementing `Shape` interface) rather than modifying it, leading to a more maintainable and scalable software architecture.

---