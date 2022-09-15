package edu.java.class05;

public class ClassMainn05 {

    public static void main(String[] args) {
        // Score 타입의 객체 생성, 메서드들을 테스트.
        Score score1 = new Score(11, 20 ,30);
        score1.scorePrint();
        System.out.println("합계 : "+score1.sum());
        System.out.println("평균 : "+score1.avg());
        System.out.println("----------");
        
        Score score2 = new Score(100, 90, 80);
        score2.scorePrint();
        
        // Student 타입의 객체 생성, 메서드를 테스트.
        System.out.println("---------------");
        Student stu1 = new Student(10, "1", score1);
        stu1.imformation();
        stu1.score = score2;
        
        System.out.println("-------------");        
        stu1.imformation();
        

    }

}
