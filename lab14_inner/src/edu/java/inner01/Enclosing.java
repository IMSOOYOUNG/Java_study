package edu.java.inner01;

public class Enclosing {
    // field
    public static int classVariable = 123; // static 변수
    private int instanceVariable; // 인스턴스 멤버
    
    // constructor
    public Enclosing(int instanceVariable) {
        this.instanceVariable = instanceVariable;
    }
    
    // method
    public static void classMethod() {
        System.out.println("클래스 변수 = " + classVariable);
        // static 메서드에서는 static으로 선언된 멤버(변수, 메서드)만 사용 가능!
    }
    
    // 2) instance method
    public void instanceMethod() {
        System.out.println("Class Var = " + classVariable);
        System.out.println("Instance Var = " + instanceVariable);
    }
    
    // static inner class(nested class) 
    // - 외부 클래스의 객체 생성 여부와 상관 없이 생성자 호출하고 사용할 수 있는 클래스.    
    // - 외부 클래스의 static 멤버(필드, 메서드)들만 사용 가능.    
    public static class Nested {
        // field
        private int a;
        
        // constructor
        public Nested(int b) {
            this.a = a;
        }
        
        // method
        public void test() {
            System.out.println("--- Nested Class ---");
            System.out.println("내부 a = " + a);
            System.out.println("외부 static 변수 = " + classVariable);
        }
    }
    
}
