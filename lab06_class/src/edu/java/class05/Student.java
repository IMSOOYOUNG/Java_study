package edu.java.class05;

public class Student {
    // field 
    int stuNo; // 학번(학생 아이디)
    String stuName; // 학생 이름
    Score score; // 국어/영어/수학 점수
    
    // constructor
    // (1) 기본 생성자
    public Student() {}
    
    // (2) argument: int, String, Score
    public Student(int stuNo, String stuName, Score score) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.score = score;
    }
    
    // (3) argument: int, String, int, int, int
    public Student(int stuNo, String stuName, int korean, int english, int math) {
        
//        this.stuNo = stuNo;
//        this.stuName = stuName;     
//        if(score != null) {
//            this.score = new Score(korean, english, math);
//        }
        
        this(stuNo, stuName, new Score(korean, english, math));
        
        
    }
    
    // method - 학생 정보(학번, 이름, 국/영/수 과목 점수, 총점, 평균)를 출력
    public void imformation() {
       System.out.println("학번 : "+stuNo);
       System.out.println("이름 : "+stuName);
       if(score != null) {
           this.score.scorePrint();
           System.out.println("합계 : "+score.sum()); 
           System.out.println("평균 : "+score.avg()); 
       }else {
           System.out.println("점수: null");
       }
       
    }
    
    
    
}
