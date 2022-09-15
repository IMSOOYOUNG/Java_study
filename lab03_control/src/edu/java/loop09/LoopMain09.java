package edu.java.loop09;

public class LoopMain09 {

    public static void main(String[] args) {
        // 1부터 100까지 자연수들의 합: sum = 1 + 2 + 3 .... + 99 +100
        int sum = 0;
        
        for(int i=1; i<=-100; i++) {
            sum += i;
        }
        System.out.println(sum);
        
        
        // Ex 4-2. 100 이하의 자연수 중 3의 배수들의 합: sum = 3 + 6 + 9 + ... +99
        sum = 0;
        for(int n = 3; n <= 100; n +=3) {
            sum += n;
        }
        System.out.println("3의 배수들의 합 = " + sum);
        
        
    }

}
