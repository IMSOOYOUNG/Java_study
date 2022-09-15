package edu.java.inheritance09;

// 직사각형(가로, 세로)
public class Rectangle extends Shape {
    
    protected Rectangle(double width, double height) {
        super("rectangle");
        this.width = width;
        this.height = height;
    }

    private double width;
    private double height;
    
    
    @Override
    public double area() {
        return this.width * this.height;
    }
    
    @Override
    public double perimeter() {
        return this.width * 2 + this.height * 2;
    }
}
