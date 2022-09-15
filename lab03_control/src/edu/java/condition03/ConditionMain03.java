package edu.java.condition03;

import java.util.Scanner;

public class ConditionMain03 {

    public static void main(String[] args) {
        // Scanner 타입의 변수 선언, 초기화.
        
        // int 타입 변수에 콘솔에서 입력한 정수를 저장.
        
        // 입력한 점수가 90 이상이면, A
        // 80점 이상이면, B
        // 70점 이상이면, C
        // 60점 이상이면, D
        // 60점 미만이면, F 출력
        
        Scanner scan = new Scanner(System.in);
        System.out.println("점수를 입력>>");
        int input = scan.nextInt(); 

        if(input >= 90) {
            System.out.println("A");
        }else if(input >= 80) {
            System.out.println("B");
        }else if(input >= 70) {
            System.out.println("C");
        }else if(input >= 60) {
            System.out.println("D");
        }else {
            System.out.println("F");
        }
        
    }

}
