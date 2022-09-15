package edu.java.inheritance09;

public class AbstractMain03 {

    public static void main(String[] args) {
        // Rectangle, Circle 클래스를 구현(implement)
        Rectangle rectangle = new Rectangle(10 , 10);
        Circle circle = new Circle("circle", 5);
        
        // Rectangle, Circle 타입의 객체에서 draw() 메서드 동작 여부 테스트
        rectangle.draw();
        circle.draw();
        
        Shape[] sp = {new Rectangle(10 , 10), new Circle("circle", 5), new Square(3)};
        
        for(Shape s : sp) {
            s.draw();
        }

    }

}
