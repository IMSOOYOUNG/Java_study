package edu.java.class06;

public class ClassMain06 {

    public static void main(String[] args) {
        Account account1 = new Account(100, 100);
        System.out.println(account1);
        account1.printAccountInfo();
        System.out.println("입금 후 잔액 : "+account1.deposit(100));
        System.out.println("출금 후 잔액 : "+account1.withdraw(100));      
        
        System.out.println();
        
        Account account2 = new Account(200, 2000);
        account2.printAccountInfo();
        System.out.println("이체하기 : "+account2.transfer(account1, 1000));
        account2.printAccountInfo();
        
        
        
        
        
        
        
    }

}
