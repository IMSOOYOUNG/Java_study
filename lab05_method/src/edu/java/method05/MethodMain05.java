package edu.java.method05;

public class MethodMain05 {

    public static void main(String[] args) {
        // 메서드 작성 연습
        
        int[] scores = {70, 60, 100, 50, 81};
        
        int sum = sum(scores);
        System.out.println("총점 = " + sum); // 360
        
        double avg = mean(scores);
        System.out.println("평균 = " + avg); // 72.0
              
        int max = max(scores);
        System.out.println("최댓값 = " + max); // 100
          
        int min = min(scores);
        System.out.println("최솟값 = " + min); // 50
     
        double var = variance(scores);
        System.out.println("분산 = "+ var);
        
        double sta = standardDeviation(scores);
        System.out.println("표준편차 = "+ sta);
        
        
    }
    
    public static double variance(int[] array) {
        // 데이터: {x1, x2, ..., xn)
        // 평균: mu = (x1 + x2 + ... + xn) / n
        // 분산: var = ((x1 - mu)^2 + (x2 -mu)^2 + ... + (xn - mu)^2) / n
        // 표준편차: std = sqrt(var)
        
        double mu = mean(array);
        double total = 0;
        for(int x : array) {
            total += (x - mu) * (x - mu);
        }
        double var = total / array.length;
        
        return var;
    }
    
    public static double standardDeviation(int[] array) {
        return Math.sqrt(variance(array));
    }
    
    
    
    /**
     * 배열을 전달 받아서, 합계 반환.  
     * @param scores int[]
     * @return 
     */
    public static int sum(int[] scores) {
        int sum = 0;
        for(int i=0; i < scores.length; i++) {
            sum += scores[i];
        }
        
        return sum;
    }
    
    public static double mean(int[] scores) {
        double avg = (double)sum(scores) / scores.length;
        
        return avg;
    }
    
    public static int max(int[] scores) {
        int max = scores[0];
        for(int i=0; i < scores.length; i++) {
            max = (max < scores[i]) ? scores[i] : max; 
        }
        
        return max;
    }
    
    public static int min(int[] scores) {
        int min = scores[0];
        for(int i=0; i < scores.length; i++) {
            min = (min < scores[i]) ? min : scores[i]; 
        }
        
        return min;
    }
    
}
