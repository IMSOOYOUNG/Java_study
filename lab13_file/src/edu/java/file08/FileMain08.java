package edu.java.file08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileMain08 {

    public static void main(String[] args) {
        // Student를 저장하는 ArrayList를 선언, 생성.
        ArrayList<Student> studentList = new ArrayList<>();

        // ArrayList에 Student 객체 5개를 저장.
        for(int i=0; i<5; i++) {
            studentList.add(new Student(i, "홍길동"+i, new Score(i*10, i*10, i*10) ) );
        }
        
        String fileName = "data/student_list.txt";
        
        // ArrayList를 파일에 write.
        try (
                FileOutputStream fin = new FileOutputStream(fileName);
                BufferedOutputStream bin = new BufferedOutputStream(fin);
                ObjectOutputStream oin = new ObjectOutputStream(bin);
        ) {
            oin.writeObject(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 파일에서 ArrayList 객체를 read.
        // ArrayList의 원소들을 한 줄씩 출력.
        
        try (
                FileInputStream fin = new FileInputStream(fileName);
                BufferedInputStream bin = new BufferedInputStream(fin);
                ObjectInputStream oin = new ObjectInputStream(bin);
        ) {
            ArrayList<Student> list = (ArrayList<Student>) oin.readObject();
            for(Student s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        

    }

}
