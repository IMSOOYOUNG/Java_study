package edu.java.map03;

import java.util.HashMap;

public class MapMain03 {

    public static void main(String[] args) {
        // 단어 개수 세기(word counting)
        // 문자열 sentence에 등장하는 단어를 key로 하고
        // 그 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고 출력.
        // 결과: {땅=2, 바다=1, 사람=1, 하늘=2}    
        String sentence = "하늘 바다 땅 하늘 땅 사람";
        
        // sentence 문자열을 공백으로 구분해서 단어들로만 이루어진 배열을 만듦.
        // 배열의 원소(단어)들을 하났기 반복하면서
        //      단어가 Map key로 존재하지 않으면, "단어=1"을 Map에 저장.
        //      단어가 Map key로 존재하면, key에 해당하는 "value(기존 등장 횟수) +1" 값을 Map에 저장.
        
        String[] strArr = sentence.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : strArr) {
            
            if(map.get(s) == null) {
                map.put(s, 1);
            }else {
                map.put(s,map.get(s)+1 );
            }
            
        }
        System.out.println(map);
        
    }

}
