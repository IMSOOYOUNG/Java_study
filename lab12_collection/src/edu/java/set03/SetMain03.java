package edu.java.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {
        // HashSet<E> 사용. 
        HashSet<Integer> set = new HashSet<>();
        int setSize = 0;

        // [0, 10) 범위의 정수 난수 5개를 저장.
        Random random = new Random();
        
        while(setSize < 5) {
            set.add(random.nextInt(0, 10));
            setSize = set.size();
        }
        
        // Set의 내용을 출력.
        System.out.println(set);

    }

}
