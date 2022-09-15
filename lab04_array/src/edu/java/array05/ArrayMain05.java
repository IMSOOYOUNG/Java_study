package edu.java.array05;

public class ArrayMain05 {

    public static void main(String[] args) {
        // 문자열 1차원 배열 
        String[] bts = {"정국", "뷔", "RM", "지민", "슈가", "제이홉", "진"};
        String[] newJeans = {"민지","하니","다니엘", "혜린", "혜인"};
        
        // 문자열 2차원 배열
        String[][] idols = {bts, newJeans};
        
        // for 문을 사용해서 idols 멤버들을 출력
        for(int i=0; i<idols.length; i++) {
            for(int j=0; j<idols[i].length; j++) {
               System.out.print(idols[i][j]+" ");
            }
            System.out.println();
        }
        
        // for-each 문을 사용해서 idols 멤버들을 출력
        for(String[] arr : idols) {
            for(String a : arr) {
                System.out.print(a + "\t ");
            }
            System.out.println();
        }
        

    }

}
