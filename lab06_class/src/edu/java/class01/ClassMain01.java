package edu.java.class01;

public class ClassMain01 {

    public static void main(String[] args) {
        // User 클래스 타입으로 변수 선언, 객체 생성, 초기화.
        User user1 = new User();
        System.out.println(user1);
        System.out.println(user1.userId);
        System.out.println(user1.password);
        System.out.println(user1.age);

        user1.userId = "admin";
        user1.password = "1234";
        user1.age = 16;
        
        System.out.println(user1.userId);
        System.out.println(user1.password);
        System.out.println(user1.age);
        
        User user2 = new User("guest", "guest", 0);
        System.out.println(user2.userId);
        System.out.println(user2.password);
        System.out.println(user2.age);
                
        User user3 = new User("Noname");
        System.out.println(user3.userId);
        System.out.println(user3.password);
        System.out.println(user3.age);
        
    }

}
