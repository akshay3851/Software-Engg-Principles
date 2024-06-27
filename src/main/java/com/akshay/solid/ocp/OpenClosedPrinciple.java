
package com.akshay.solid.ocp;

/**
 * Interface representing a Shape.
 */
interface Shape {
    double calculateArea();
}

/**
 * The OpenClosedPrinciple class demonstrates the Open/Closed Principle (OCP) in software engineering.
 *
 * <p>
 * According to OCP, software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
 * This principle encourages the use of abstraction and polymorphism to allow behavior to be extended without modifying existing code.
 * </p>
 */
public class OpenClosedPrinciple implements Shape {

    @Override
    public double calculateArea() {
        return 0;
    }

}

/**
 * Rectangle class implementing the Shape interface.
 */
class Rectangle implements Shape {

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
class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}