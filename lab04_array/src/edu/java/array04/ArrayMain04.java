package edu.java.array04;

public class ArrayMain04 {

    public static void main(String[] args) {
        // 2차원 배열: 1차원 배열들을 원소로 갖는 배열.
        // 2차원 배열은 인덱스가 2개.
        // 타입[][] 배열이름 = { {...}, {...}, ...}

        int[][] array = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12,5}
        };
        System.out.println(array);
        
        // 2차원 
        System.out.println("array.length = "+array.length);
        
        
        // for 문을 사용한 배열 원소 출력.
        for(int i = 0; i<array.length; i++) {
            for(int j = 0; j<array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        
        for (int[] a : array) {
            System.out.println(a);
            for(int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
        
    }

}
