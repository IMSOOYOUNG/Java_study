package edu.java.class03;

// class = field + constructor + method ==> data type
public class Rectangle {
    // field - 가로, 세로
    double width;
    double height;
    
    // constructor - 기본 생성자, argument 2개를 갖는 생성자
    public Rectangle() {
        
    }
    public Rectangle(double x, double y) {
        width = x;
        height = y;
    }
    
    // method - 둘레 길이, 넓이
    public double perimeter () {
        return (width + height) * 2;
    }
    
    // 넓이
    public double area() {
        return width * height;
    }
    
    
    
}
