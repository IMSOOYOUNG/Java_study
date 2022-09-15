package edu.java.modifier02;

import edu.java.modifier01.AccessTest;
// 같은 패키지에 있는 클래스들은 import 문장 없이 변수 선언에서 클래스 이름을 사용할 수 있음.
// 다른 패키지에 있는 클래스 이름으로 변수를 선언할 때는
// (1) import 문장을 작성하고 클래스 이름을 사용하거나,
// (2) 패키지를 포함한 클래스 전체 이름(full name)을 사용.
// java.lang 패키지에 포함된 클래스들은 import 문장 없이 클래스 이름을 사용할 수 있음.
//  (예) java.lang.String, java.lang.Math, java.lang.System, ...

public class ModifierMain02 {

    public static void main(String[] args) {
        // Ctrl + shift + o: import 문장 최적화
        // edu.java.modifier01.AccessTest 객체 생성.
        edu.java.modifier01.AccessTest test = new edu.java.modifier01.AccessTest(1, 2, 3, 4);
        //test.c = 100;
        // private, (package), protected 멤버 변수들은 보이지 않음. 직접 접근 불가능.
        test.printMembers();
        
    }

}
