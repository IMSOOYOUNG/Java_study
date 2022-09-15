package edu.java.array07;

import java.util.Random;

public class ArrayMain07 {

    public static void main(String[] args) {
        // Chapter 6-2 Ex. 4 (p200)
        // 정수(int) 10개를 저장하는 배열(array)을 선언.
        
        // 배열에 0 이상 10 이하의 정수 난수 10개를 저장.
        
        // 배열의 내용 출력.
        
        // 배열에서 최댓값을 찾으세요.
        // max = array[0] 가정
        // for (array의 모든 원소들)
        
        int[] array = new int[10];
        
        Random random = new Random();
        
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(11);
        }
        
        for(int arr : array) {
            System.out.print(arr +" ");
        }
        System.out.println();
        
        int max = array[0];
        
        for(int i = 0; i < array.length; i++) {
            if(max < array[i]) {
                max = array[i];
            }
            
//            max = (max < array[i]) ? max = array[i] : max;
        }
        System.out.println("max = "+max);
        
        

    }

}
