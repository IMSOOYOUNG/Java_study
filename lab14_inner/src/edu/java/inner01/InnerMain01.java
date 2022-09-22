package edu.java.inner01;

import edu.java.inner01.Enclosing.Nested;

/*
 * 변수 선언 위치:
 * 1. 필드: 클래스의 멤버로 선언하는 변수.
 *      (1) 인스턴스 변수: static이 아닌 필드.
 *          - 객체를 생성한 후에, 그 참조변수를 이용해야 사용할 수 있는 필드.
 *      (2) 클래스 변수: static으로 선언하는 필드.
 *          - 프로그램 시작될 때 클래스 로더에 의해서 메모리에 미리 로딩되는 필드.
 *          - 클래스 이름을 이용해서 사용할 수 있는 필드.
 * 2. 지역 변수: 메서드 안에서 선언하는 변수.
 *      - 선언된 위치에서부터 변수가 포함된 블록({})이 끝날 때까지만 사용 가능한 변수.
 *      - 파라미터도 지역 변수의 한 종료.
 *      - 지역 변수는 static으로 선언할 수 없음!
 * 
 * 내부 클래스/인터페이스(inner class/interface): 다른 클래스/인터페이스의 내부에서 선언하는 클래스/인터페이스.
 * 외부 클래스(outer/enclosing class): 내부 클래스를 가지고(감싸고) 있는 클래스.
 * 1. 멤버 내부 클래스: 필드(멤버 변수)를 선언하는 위치에서 선언하는 클래스.
 *      (1) 인스턴스 내부 클래스: static이 아닌 내부 클래스
 *          - 외부 클래스의 인스턴스가 먼저 생성되고 나서, 그 참조 변수를 이용해서 사용할 수 있는 클래스.
 *      (2) static 내부 클래스 - 중첩 클래스(nested class)
 *          - 외부 클래스의 인스턴스 생성 여부와 상관없이 사용할 수 있는 내부 클래스.
 * 2. 지역 내부 클래스: 메서드 안에서 선언하는 클래스.
 * 3. 익명 (내부) 클래스(annoymous class): 이름이 없는 내부 클래스.
 *      - 클래스의 선언(정의)와 동시에 객체 생성을 해야만 하는 클래스.
 *      
 * 외부 클래스의 접근 수식어: public, (package)
 * 내부 클래스의 접근 수식어: private, (package), protected, public
 * 
 */

public class InnerMain01 {
    public static int MAX = 3; // 클래스 필드(static인 멤버 변수)
    private int x; // 인스턴스 필드(static이 아닌 멤버 변수)

    public static void main(String[] args) {
        System.out.println("MAX = " + InnerMain01.MAX);
        
        InnerMain01 app = new InnerMain01(); // 객체 생성
        System.out.println("x = " + app.x);
        
        // Outer 타입의 변수 선언, 객체 생성
        Outer outer1 = new Outer(1, 2);
        System.out.println(outer1);
        
        // Outer.Inner 타입의 변수 선언, 객체 생성
        Outer.Inner inner1 = outer1.new Inner(3);
        inner1.printInfo();
        
        Outer outer2 = new Outer(100, 200);
        Outer.Inner inner2 = outer2.new Inner(3);
        inner2.printInfo();
        
        Outer.Inner inner3 = outer1.new Inner(100);
        inner3.printInfo();
        
        // static 내부 클래스 타입의 변수 선언, 객체 생성
        Enclosing.Nested nested = new Enclosing.Nested(100);
        nested.test();
        
        Nested nested2 = new Nested(123);
        nested2.test();
        
    }

}
