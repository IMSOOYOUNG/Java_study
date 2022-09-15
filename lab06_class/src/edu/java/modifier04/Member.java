package edu.java.modifier04;

/*
 * field: 아이디, 비밀번호
 * constructor: argument 2개를 갖는 생성자.
 * method: 아이디 getter, 비밀번호 getter/setter
 */

public class Member {

    private String id;
    private String password;
    
    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    public String getterId() {
        return this.id;
    }
    
    public String getterPassword() {
        return this.password;
    }
    
    public void setterPassword(String password) {
        this.password = password;
    }
    
    
    
}
