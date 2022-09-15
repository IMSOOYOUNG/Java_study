package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMain03 {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "SQL", "HTML", "CSS", "JavaScript", "Servlet", "JSP", "Spring", "Python");
        System.out.println(languages);

        // 리스트 languages에서 5글자 이상인 문자열들만 저장하는 리스트를 만들고 출력.
        List<String> longWords = new ArrayList<>();
        
        for(int i=0; i<languages.size(); i++) {
            if( languages.get(i).length() >= 5) {
                longWords.add(languages.get(i));
            }
        }
        System.out.println(longWords);
        
        List<String> longWords2 = new ArrayList<>();
        Iterator<String> itr = languages.iterator();
        while(itr.hasNext()) {
            String s = itr.next();
            if(s.length() >= 5 ) {
                longWords2.add(s);
            }
        }
        System.out.println(longWords2);
        
        // 리스트 languages의 원소들의 글자수를 저장하는 리스트를 만들고 출력. 
        List<Integer> wordLength = new ArrayList<>();
        
        for(int i=0; i<languages.size(); i++) {
            wordLength.add(languages.get(i).length());
        }
        System.out.println(wordLength);
        
        // 정수(1, 2)들을 저장하는 리스트를 만들고 초기화.
        List<Integer> genderCodes = Arrays.asList(1, 1, 2, 2, 1, 2, 2);
        System.out.println(genderCodes);
        
        // 리스트 genderCodes의 원소가 1이면 "Male", 2이면 "Female"을 저장하는 리스트를 만들고 출력.
        List<String> gender = new ArrayList<String>();
        
        for(Integer n : genderCodes) {
//            if(n == 1) {
//                gender.add("Male");
//            }else {
//                gender.add("Female");
//            }            
            gender.add((n == 1) ? "Male" : "Female");            
        }
        System.out.println(gender);
        
    }

}
