package edu.java.exception02;

import java.util.Scanner;

/*
 * try-catch 문장을 사용한 예외 처리:
 * 
 * try {
 *      정상정인 상황에서 실행할 코드들
 * } catch (Exception타입 변수이름) {
 *      예외가 발생했을 때 실행할 코드들 
 * } finally {
 *      예외 발생 여부와 상관없이 항상 실행할 코드들
 *      (try 블록이 모두 끝났을 때 또는 catch 블록이 끝났을 때 실행할 코드들)
 * }
 * 
 * (1) 예외가 발생하지 않으면 try 블록을 모두 실행하고 finally 블록을 실행함.
 * (2) try 블록 실행 중에 예외가 발생하면, 발생한 예외를 catch할 수 있는 catch 블록이 실행되고, finally 블록이 실행됨.       
 * (3) 발생할 예외를 catch할 수 있는 catch 블록이 없으면 프로그램은 비정상 종료.
 * (4) catch 블록은 발생할 수 있는 예외 종류들에 따라서 여러개를 작성할 수 있음.
 * (5) finally 블록은 선택(필수는 아님).      
 *       
 * 다형성(polymorphism): SuperType var = new SubType();
 * Exception e = new AE(); new NPE(); new AIOOBE(); ...
 * 예외 클래스의 상속 관계:
 * Object
 * |__ Throwable
 *      |__ Exception
 *          |__ RuntimeException
 *              |__ ArithmeticException, NullPointerException, ...
 * catch 블록이 여러개일 때는 하위(sub) 타입의 예외들을 먼저 catch하고,
 * 상위(super) 타입의 예외들은 나중에 catch해야 함.      
 *       
 */

public class ExceptionMain02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("x = ");
            int x = Integer.parseInt(sc.nextLine());
            
            System.out.println("y = ");
            int y = Integer.parseInt(sc.nextLine());
            
            int result = x / y;
            System.out.println("몫 = " + result);
        } catch (ArithmeticException e) {
            System.out.println("0으로는 나눌 수 없음.");
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("입력한 문자열은 정수로 변환 불가능.");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage() );
        }
        
        System.out.println("end program.");
    } 

}
