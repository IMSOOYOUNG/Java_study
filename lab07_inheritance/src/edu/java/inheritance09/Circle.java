package edu.java.inheritance09;

public class Circle extends Shape {
    private double radius;
    
    protected Circle(String type, double radius) {
        super(type);
        this.radius  = radius;
    }
    
    @Override
    public double area() {
        return 3.14 * radius * radius; 
    }
    
    @Override
    public double perimeter() {
        return this.radius * 2 * 3.14;
    }
}
