package edu.java.loop12;

public class LoopMain12 {

    public static void main(String[] args) {
        for(int i=1; i<=4; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
 
        
        System.out.println("-----------");

        for(int i=1; i<=4; i++) {
            int spaces = 4 - i; // i번째 줄에서 출력할 공백 갯수
            for(int j=1; j<=spaces; j++) { //spance 갯수만큼 반복하면서
                System.out.print(" "); // 공백 출력
            }
            for(int j=1; j<=i; j++) { // 라인 수만큼 반복하면서
                System.out.print("*"); // "*" 출력
            }
            System.out.println("");
        }
        
        System.out.println();
        
        for(int i = 1; i <= 4; i++) {
            for(int j = 4; j >= 1; j--) {
                if(j > i) {
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        
        
        
    }

}
