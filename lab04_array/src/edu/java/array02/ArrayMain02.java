package edu.java.array02;

public class ArrayMain02 {

    public static void main(String[] args) {
        // 문자열 3개를 저장할 수 있는 배열(subjects)을 선언.
        String[] subjects = new String[3];
        
        // 배열에 문자열들을 저장.
        subjects[0] = "Java";
        subjects[1] = "SQL";
        subjects[2] = "HTML";
        
        // 배열에 저장된 문자열들을 순서대로 한 줄에 출력.
        // 1) for 문
        for(int i=0; i<subjects.length; i++) {
            System.out.print(subjects[i]+" ");
        }
        
        System.out.println("\n----------");
        // 2) for-each 문
        for(String n : subjects) {
            System.out.print(n+" ");
        }
        
        System.out.println("\n---------");
        String[] names = {"김다훈", "이존규", "최은정", "김준오"};
        for(String n : names) {
            System.out.println(n);
        }
        
        System.out.println("----------");
        // boolean 5개를 저장할 수 있는 배열(boolArray)을 선언.
        // for 문을 사용해서 짝수 인덱스에는 true, 홀수 인덱스에는 false를 저장.
        // for-each 문을 사용해서 배열의 내용을 출력.
        
        boolean boolArray[] = new boolean[5];
        
        for(int i=0; i<boolArray.length; i++) {
            if(i % 2 == 0) {
                boolArray[i] = false;
            }else {
                boolArray[i] = true;
            }
        }
        
        for(boolean b : boolArray) {
            System.out.println(b);
        }
        
        System.out.println("-----------");
        // for-each 구문은 배열의 원소를 변경할 수 없음.
        int[] array = {2, 4, 6, 8};
        for(int x : array) {
            x += 1; // 배열의 원소를 변경하는 게 아니라, 변수 x의 값을 변경시킴.
        }
        
        for(int x : array) {
            System.out.print(x+" ");
        }
        System.out.println();
        
        System.out.println("---------");
        // 배열의 원소를 변경하려면 인덱스를 사용해야 함.
        for(int i = 0; i < array.length; i++) {
            array[i] += 1; // array의 인덱스 i번째 원소의 값에 1을 더함.
        }
        for(int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        
    }

}
