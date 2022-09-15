package edu.java.condition04;

import java.util.Random;

public class ConditionMain04 {

    public static void main(String[] args) {
        
        // Random 클래스: 난수를 발생시키는 기능을 가지고 있는 클래스.
        Random random = new Random(); //Random 타입의 변수를 선언, 초기화.
        
        // 0이상 100이하(101 미만)의 정수 난수 생성.
        int x = random.nextInt(101);
        System.out.println("x = " + x);
        
        int y = random.nextInt(11);
        System.out.println("y = " + y);
        
        // 두 숫자 x와 y의 차이(큰 수 - 작은 수)를 계산/
        int diff;
        if(x > y) {
            diff = x-y;
        }else {
            diff = y-x;
        }
        
        System.out.println(diff);
        
        // 삼항연산자 
        // (조건식) ? 조건이 참일 때 선택할 값 : 조건이 거짓일 때 선택할 값

        int diff2 = (x > y) ? (x - y) : (y - x);
        System.out.println(diff2);
        
        // 0이상 10이하(11미만)의 정수 난수를 생성해서 변수(z)에 저장.
        // 문자열 변수를 선언, 변수 z가 짝수이면 "even", 홀수이면 "odd"를 저장.
        // 문자열(even/odd)을 출력.
        System.out.println();
        
        int z = random.nextInt(11);
        String str = (z % 2 == 0) ? "even" : "odd";
        System.out.println("z : "+z);
        System.out.println("문자열 : "+str);
        
        // 0이상 10이하(11미만)의 정수 난수 2개를 저장.
        // int 타입 변수 bigger에 두 난수 중에서 더 크거나 같은 숫자를 저장.
        // bigger를 출력
        System.out.println();
        
        int random_num1 = random.nextInt(11);
        int random_num2 = random.nextInt(11);
        int bigger = (random_num1 >= random_num2) ? (random_num1) : (random_num2);
        System.out.println("난수1 : "+random_num1);
        System.out.println("난수2 : "+random_num2);
        System.out.println("bigger  : "+bigger);
        
    }

}
