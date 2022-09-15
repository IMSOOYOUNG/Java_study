package edu.java.mvc.view;

public enum Menu {
    QUIT, CREATE, SELECT_ALL, SELECT_BY_INDEX, UPDATE, UNKNOWN;
    
    // int -> Menu 변환 메서드
    public static Menu getValue(int n) {
        Menu[] array = values();
        int lastIndex = array.length - 1;
        if (n >= 0 && n < lastIndex) { // 사용할 수 있는 메뉴 번호
            return array[n];
        } else { // 잘못된 메뉴 번호
            return array[lastIndex];
        }
        
    }
    
}
