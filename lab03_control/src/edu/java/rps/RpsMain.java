package edu.java.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsMain {

    public static void main(String[] args) {
        // 가위 바위 보
        // 0 가위, 1 바위, 2 보

        Random random   = new Random();
        Scanner scan    = new Scanner(System.in);        
        
        int computer    = random.nextInt(3);
        
        System.out.println("'가위'는 0, '바위'는1, '보'는2를 입력하세요.");
        int user        = scan.nextInt();
        
        switch(user) {
        case 0:
            System.out.println("user : 가위");
            break;
        case 1:
            System.out.println("user : 바위");
            break;
        case 2:
            System.out.println("user : 보");
            break;
        }
        
        
        if(computer == 0) {
            
            System.out.println("computer : 가위");
            if(user == 0) {
                System.out.println("비겼습니다.");
            }else if(user == 1 ) {
                System.out.println("user가 이겼습니다.");
            }else if(user == 2) {
                System.out.println("user가 졌습니다.");
            }
            
        }else if(computer == 1) {
            
            System.out.println("computer : 바위");
            if(user == 0) {
                System.out.println("user가 졌습니다.");
            }else if(user == 1 ) {
                System.out.println("비겼습나다.");
            }else if(user == 2) {
                System.out.println("user가 이겼습니다.");
            }
            
        }else if(computer == 2) {
            
            System.out.println("computer : 보");
            if(user == 0) {
                System.out.println("user가 이겼습니다.");
            }else if(user == 1 ) {
                System.out.println("user가 졌습니다.");
            }else if(user == 2) {
                System.out.println("비겼습나다.");
            }
            
        }
        
        
        
        
    }

}
