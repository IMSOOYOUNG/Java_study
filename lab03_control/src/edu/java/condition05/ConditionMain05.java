package edu.java.condition05;

import java.util.Random;
//Crtl+Shift+O: 필요없는 import문을 지워줌

public class ConditionMain05 {

    public static void main(String[] args) {
        // Random 타입 변수를 선언하고, 초기화
        
        // Java 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        
        // SQL 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        
        // JSP 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        
        // 세 과목의 평균을 계산.
        
        // 모든 과목의 점수가 40점 이상이고, 평균이 60점 이상이면 "합격",
        // 그렇지 않으면 "불합격" 출력

        Random random = new Random();
        
        int java_num = random.nextInt(101);
        int sql_num = random.nextInt(101);
        int jsp_num = random.nextInt(101);
        
        int total = java_num + sql_num + jsp_num;
        int avg = total / 3;

        System.out.println("java : "+java_num);
        System.out.println("sql : "+sql_num);
        System.out.println("jsp : "+jsp_num);
        System.out.println("평균 : "+avg);
        
        if(java_num >= 40 && sql_num >= 40 && jsp_num >= 40 && avg >= 60) {
            System.out.println("합격");
        }else {
            System.out.println("불합격");
        }
        
        
        
    }

}
