package edu.java.loop08;

public class LoopMain08 {

    public static void main(String[] args) {
/*
        for(int dan = 2; dan < 10; dan++) {
            System.out.println("---" + dan + "단 ---");
            for(int n = 1; n < 10; n++) {
                System.out.println(dan + " x " + n + " = " + (dan * n));
            }
        }
  */      
    /*
        int dan = 2;
        while(dan < 10) {
            System.out.println("---" + dan + "단---"); 
            
            int j = 1;
            while(j < 10) {
                System.out.println(dan + " x " + j +  " = " + dan * j);
                j++;
            }
            
            dan++;
        }    
    */
    
        System.out.println();
        // 2단은 2x2까지, 3단은 3x3까지, 4단은 4x4까지, ..., 9단은 9x9까지 출력
        
        for(int dan = 2; dan < 10; dan++) {
            System.out.println("---" + dan + "---");
            for(int i = 1; i <= dan; i++) {
                System.out.println(dan + " x " + i + " = " + dan*i);
            }
            
        }
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("------------------");
        int dan = 2;
        while(dan < 10) {
            System.out.println("---" + dan + "---");
            int i = 1;
            while(i <= dan) {
                System.out.println(dan + " x " + i + " = " + dan*i);
                i++;
            }
            dan++;
        }
        
        

    }

}
