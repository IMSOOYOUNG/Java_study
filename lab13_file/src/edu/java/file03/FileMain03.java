package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMain03 {

    public static void main(String[] args) {
        // data/ratings.data 파일을 읽고 ratings_copy.data 파일에 복수
        // read(), write(int b)를 사용했을 때 
        // read(byte[] b), write(byte[] b, int off, int len)를 사용했을 때
        // 복사 시간의 차이를 비교.
        
        FileInputStream in = null;
        FileOutputStream out = null;
        
        long startTime = System.currentTimeMillis();
        try {
            in = new FileInputStream("data/ratings.dat");
            out = new FileOutputStream("data/ratings_copy.dat");
            
            while(true) {
                int result = in.read();
                if(result == -1) {
                    break;
                }
                
                out.write(result);
            }
            
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("종료 시간 = " + elapsedTime );
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        
        long startTime2 = System.currentTimeMillis();
        try {
            in = new FileInputStream("data/ratings.dat");
            out = new FileOutputStream("data/ratings_copy.dat");
            
            while(true) {
                byte[] buffer = new byte[20];
                int result = in.read(buffer);
                if(result == -1) {
                    break;
                }
                
                out.write(buffer, 0, result);
            }
            
            long endTime2 = System.currentTimeMillis();
            long elapsedTime2 = endTime2 - startTime2;
            System.out.println("종료 시간2 = " + elapsedTime2 );
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        

    }

}
