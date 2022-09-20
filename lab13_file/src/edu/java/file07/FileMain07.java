package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.java.file06.Product;

public class FileMain07 {

    public static void main(String[] args) {
        // edu.java.file06.Product 타입의 객체를 1,000,000개 생성하고 ArrayList에 저장.
        ArrayList<Product> productList = new ArrayList<>();        
        int objCount = 1_000_000;
        
        for(int i=0; i<objCount; i++) {
            productList.add( new Product(i, "이름"+i, i*10) );
        }
        System.out.println(productList.size());
        
        // ArrayList의 내용을 product_list.dat 파일에 write - 시간 측정.
        String fileName = "data/product_list.dat";
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oout = null;
        
        try {
            fout = new FileOutputStream(fileName);
            bout = new BufferedOutputStream(fout);
            oout = new ObjectOutputStream(bout);
            
            long startTime = System.currentTimeMillis();
            
            oout.writeObject(productList);
            
            long endTime = System.currentTimeMillis();
            long elapseTime = endTime - startTime;
            System.out.println("작성 시간 : "+elapseTime);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // product_list.dat 파일에서 데이터를 읽어서 ArrayList 타입으로 변환 - 시간 측정.
        try (
                FileInputStream fin = new FileInputStream(fileName);
                BufferedInputStream bin = new BufferedInputStream(fin);
                ObjectInputStream oin = new ObjectInputStream(bin);
        ) {            
            long startTime = System.currentTimeMillis();
            
            ArrayList<Product> list = (ArrayList<Product>) oin.readObject();
            
            long endTime = System.currentTimeMillis();
            long elapseTime = endTime - startTime;
            System.out.println("ArrayList 타입으로 변환 : "+elapseTime);
            System.out.println(list.get(3));
        } catch(Exception e) {
            e.printStackTrace();
        }
     
        
    }

}
