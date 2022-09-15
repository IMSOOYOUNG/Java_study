package edu.java.method03;

public class MethodMain03 {

    public static void main(String[] args) {
        
        countdown(-1);
        
    }
    
    public static void countdown(int n) {
        
        if(n<0) {
            System.out.println("n은 0이상의 정수여야 함.");
            return;
        }
        
        for(int i=n; i>=0; i--) {
            System.out.println(i);
        }
    
    }
    
}
