package edu.java.array09;

import java.util.Scanner;

public class ArrayMain09 {

    public static void main(String[] args) {
        // 6
        
        boolean run = true;
        int studentNum = 0;
        int[] scores = null;
        Scanner scanner = new Scanner(System.in);
        
        while(run) {
            System.out.println("--------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("--------------------------------");
            System.out.print("선택> ");
            
            int selectNo = Integer.parseInt(scanner.nextLine());
            
            if(selectNo == 1) {
                System.out.print("학생수> ");
                studentNum = Integer.parseInt(scanner.nextLine());
                scores = new int[studentNum];
            }else if(selectNo == 2) {
                
                if(scores == null) {
                    System.out.println("학생수를 먼저 입력하세요...");
                    continue; // while 반복문을 처음부터 다시 시작.
                }
                for(int i = 0; i<scores.length; i++) {
                    System.out.print("scores["+i+"]> ");
                    scores[i] = Integer.parseInt(scanner.nextLine());
                }
               
            }else if(selectNo == 3) {
//                for(int i = 0; i < scores.length; i++) {
//                    System.out.println("scores["+i+"]>"+scores[i]);
//                }
                if(scores == null) {
                    System.out.println("학생수를 먼저 입력하세요...");
                    continue; // while 반복문을 처음부터 다시 시작.
                }
                int count = 0;
                for(int x : scores) {
                    System.out.print("score["+count+"]"+ x);
                    count++;
                }
                
            }else if(selectNo == 4) {
                
                if(scores == null) {
                    System.out.println("학생수를 먼저 입력하세요...");
                    continue; // while 반복문을 처음부터 다시 시작.
                }
                
                int max = scores[0];
                int total = 0;
                for(int i=0; i < scores.length; i++) {
                    if(max < scores[i]) {
                        max = scores[i];
                    }
                    total += scores[i];
                }
                
                double avg = (double)total/studentNum;
                System.out.println("최고 점수: " + max );
                System.out.println("평균 점수: " + avg );
                
            }else if(selectNo == 5) {
                run = false;
            }
            
        }
        
        System.out.println("프로그램 종료");

    }

}
