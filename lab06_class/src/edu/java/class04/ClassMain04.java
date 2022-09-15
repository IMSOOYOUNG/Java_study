package edu.java.class04;

public class ClassMain04 {

    public static void main(String[] args) {
        // Circle 기본 생성자 이용.
        Circle c1 = new Circle();
        
        System.out.println("c1 = "+c1);
        System.out.println("c1 반지름 = "+c1.radius);
        System.out.println("c1 둘레 = "+c1.perimeter());
        System.out.println("c1 넓이 = "+c1.area());
        
        // argument를 갖는 생성자 이용.
        Circle c2 = new Circle(10);
        System.out.println("c2 = "+c2);
        System.out.println("c2 반지름 = "+c2.radius);
        System.out.println("c2 둘레 = "+c2.perimeter());
        System.out.println("c2 넓이 = "+c2.area());
        
        // 생성자를 호출할 때마다 메모리의 다른 주소에 다른 객체가 만들어짐.
        Circle c3 = new Circle(10);
        System.out.println("c3 = "+c3);
        
        
    }
    

}
