package edu.java.loop02;

public class LoopMain02 {

    public static void main(String[] args) {
        // 복합 할당 연산자: x=, -=, *=, /=, ...
        int x = 1;
        //x = x + 3;
        x += 3;
        
        // 0 2 4 6 8 10을 한 줄씩 출력
       /*for(int i = 0; i<=10; i++) {
            if(i%2 == 0) {
               System.out.println(i); 
            }
        }
        */
        for(int i = 0; i<=10; i+=2) {
           System.out.println(i);     
        }
        
        
    }

}
