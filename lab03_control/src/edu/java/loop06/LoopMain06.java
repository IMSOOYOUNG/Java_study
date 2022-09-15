package edu.java.loop06;

public class LoopMain06 {
    
    public static void main(String args[]) {
        // for 반복문
        for(int i = 1; i <=5; i++) {
            System.out.println(i);
        }
        
        System.out.println("------");
        
        // while 반복문
        int n = 1;
        while(n <= 5) {
            System.out.println(n);
            n++;
        }
        
        System.out.println("---------");
        // 10부터 1까지 정수들을 내림차순으로 한 줄에 출력하세요. (10, 9, 8, 7, 6 ..3 2 1)
        int i = 10;
        
        while(i > 0) {
            System.out.print(i+"\t");
            i--;
        }
        
        System.out.println();
        System.out.println("-------");
        // 10이하의 양의 홀수들을 한 줄에 출력하세요. (1 3 5 7 9)
        int j = 1;
        
        while(j <= 10) {
            System.out.print(j+"\t");
            j = j+2;
        }
        
        
    }
    
    
}
