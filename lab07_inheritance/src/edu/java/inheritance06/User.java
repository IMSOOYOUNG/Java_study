package edu.java.inheritance06;

public class User {
    // field: 사용자 아이디, 비밀번호
    private String userId;
    private String password;
    
    // 생성자: 기본 생성자, argument를 갖는 생성자.
    public User() {
        
    }
    
    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    
    // getters/setters
    public String getId() {
        return this.userId;
    }
    
    public void setId(String userId) {
        this.userId = userId;
    }
    
    public String getPassWord() {
        return this.password;
    }
    
    public void setPassWord(String password) {
        this.password = password;
    }
    
    // toString() 재정의: User 객체를 출력할 때 아이디와 비밀번호가 출력될 수 있도록.
    @Override
    public String toString() {
        return String.format("User(userId=%s, password=%s)", this.userId, this.password);
//        return "User(userId=" + this.userId + ", password= " +this.password + ")";
    }
    
    // equals() 재정의: 아이디가 일치하는 User 객체는 같은 객체.
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        
        if(obj instanceof User) {
            User user = ((User) obj);
            result = this.userId.equals(user.getId());
        }
        
        return result;
    }
    
    // hashCode() 재정의: 아이디가 같으면 해쉬코드(int)도 같으면 됨.
    @Override
    public int hashCode() {
        return this.userId.hashCode();
    }
    
}
