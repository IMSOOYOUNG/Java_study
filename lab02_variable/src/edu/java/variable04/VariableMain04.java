package edu.java.variable04;

import java.util.Scanner;

public class VariableMain04 {

    public static void main(String[] args) {
        // 콘솔 창에서 키보드로 숫자를 입력받아서 변수에 저장.

        // 1. scanner 타입의 변수를 선언하고 초기화.
        /*
         * Scanner scanner = new Scanner(System.in);
         * 
         * System.out.println("정수를 입력>>>");
         * 
         * // 2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 저장. int number = scanner.nextInt();
         * System.out.println("number = "+number);
         */
        // Java 시험 점수(정수)를 입력
        // SQL 시험 점수를 입력
        // JSP 시험 점수를 입력
        // 세 과목의 총점(정수)을 계산하고 출력
        // 세 과목의 평균(실수)을 계산하고 출력.

        Scanner scan = new Scanner(System.in);

        System.out.println("Java 시험 점수를 입력>>>");
        int java_num = scan.nextInt();

        System.out.println("SQL 시험 점수를 입력>>>");
        int sql_num = scan.nextInt();

        System.out.println("Jsp 시험 점수를 입력>>>");
        int jsp_num = scan.nextInt();

        int total = java_num + sql_num + jsp_num;
        double avg = (double) total / 3;
            
        System.out.println("세 과목의 총점 : " + total);
        System.out.println("세 과목의 평균 : " + avg);

        // Ctrl + Shift + F: 소스 코드 포맷팅
        
        
    }

}
