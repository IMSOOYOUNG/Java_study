package edu.java.loop05;

import java.util.Random;
import java.util.Scanner;

public class LoopMain05 {
    
    public static void main(String[] args) {   
        // 3 6 9
        // 1부터 100까지 
        // 1줄에 10개씩 
        
        
        for(int i = 1; i <= 100; i++) {
            
            int x = i % 10;
            int y = i / 10;
                       
            if( (x == 3 || x == 6 || x == 9) || (y==3 || y == 6 || y == 9)) {
                
                if((x == 3 || x == 6 || x == 9) && (y==3 || y == 6 || y == 9)) {
                    System.out.print("**"+"\t");
                }else {
                    System.out.print("*"+"\t");
                }
                
            }else {
                System.out.print(i+"\t");
            }
            
            if(i % 10 == 0) {
                System.out.println();
            }
            
        }
        
        
        
    }
    
}
