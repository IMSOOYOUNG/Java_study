package edu.java.class04;

public class Circle {
    // field - 반지름
    double radius;
    double pi = 3.14;
    
    
    // constructor - 기본 생성자, argument를 갖는 생성자
    public Circle() {
        
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // method - 둘레 길이(2 * 3.14 * r), 넓이(3.14 * r * r)
    public double perimeter() {
        return 2 * this.pi * this.radius; // 2 * Math.PI * this.radius
    }
    
    public double area() {
        return this.pi * this.radius * this.radius;
    }
    
    
}
