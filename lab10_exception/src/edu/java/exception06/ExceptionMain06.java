package edu.java.exception06;

import java.nio.channels.IllegalChannelGroupException;

public class ExceptionMain06 {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try {
            int result = calc.divide(100, 0);
            // -> 반드시 예외 처리를 해야 하는 exceptiondmf throws한다고 선언된 메서드를
            // 호출할 때는 try-catch 구문을 사용하거나 throws 선언문을 메서드 선언에 추가해야 함.
            System.out.println(result);    
        } catch(Exception e) {
//            e.printStackTrace();
            // 예외가 발생한 이유와 예외가 발생되기 까지의 코드 호출 순서르 출력해줌.
        }
        
        System.out.println("정상 종료");
    }

}
