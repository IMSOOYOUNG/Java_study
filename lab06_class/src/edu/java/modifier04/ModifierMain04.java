package edu.java.modifier04;

public class ModifierMain04 {

    public static void main(String[] args) {
        // Member 타입의 객체 생성.
        Member m = new Member("hello", "world"); 
        System.out.println(m);
        System.out.println(m.getterId());
        System.out.println(m.getterPassword());
        m.setterPassword("?");
        System.out.println(m.getterPassword());

    }

}
