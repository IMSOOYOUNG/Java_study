package edu.java.file04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 프로그램 <== BufferedInputStream <== FileInputStream <== 파일(하드디스크)
 *  FileInputStream: 하드디스크에 저장된 파일을 읽고 메모리(RAM)에 적재.
 *  BufferedInputStream: 메모리(RAM)에 있는 파일에서 데이터를 읽는 메서드(read)를 제공.
 *      
 * 프로그램 ==> BufferedOutputStream ==> FileOutputStream ==> 파일(하드디스크)    
 *  FileOutputStream: 하드디스크에 파일을 씀.
 *  BufferedOutputStream: 메모리(RAM)에 데이터를 쓰는 메서드(write)를 제공.
 */

public class FileMain04 {

    public static void main(String[] args) {
        FileInputStream in = null; // 하드디스크 파일에서 데이터를 읽기 위한 통로
        BufferedInputStream bin = null; // 메모리 파일에서 데이터를 읽기 위한 통로
        FileOutputStream out = null; // 하드디스크 파일에 데이터를 쓰기 위한 통로
        BufferedOutputStream bout = null; // 메모리 파일에 데이터를 쓰기 위한 통로
        
        try {
            in = new FileInputStream("data/ratings.dat");
            bin = new BufferedInputStream(in);
            
            out = new FileOutputStream("data/ratings_copy.dat");
            bout = new BufferedOutputStream(out);
            
            long startTime = System.currentTimeMillis();
            while(true) {
                byte[] buffer = new byte[4 * 1024];
                int result = bin.read(buffer);
                
                if(result == -1) {
                    break;
                }
                
                bout.write(buffer, 0, result);                
            }
            long endTime = System.currentTimeMillis();
            long elapseTime = endTime - startTime;
            System.out.println("복사 완료 - "+elapseTime+"ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 가장 마지막에 생성된 InputStream과 OutputStream만 close를 하면
                // 다른 Stream 객체들은 자동으로 close가 됨.
                bin.close(); // BIS을 close를 하면, BIS이 사용하는 FIS은 자동으로 close.
                //in.close();
                bout.close(); // BOS을 close를 하면, BOS이 사용하는 FOS도 자동으로 close.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
