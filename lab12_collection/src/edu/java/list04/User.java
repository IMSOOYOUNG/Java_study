package edu.java.list04;

public class User {
    private String userId;
    private String password;
    
    //생성자: (1) 기본 생성자, (2) argument 2개를 갖는 생성자
    public User() {}
    
    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    
    // getters/seters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
//        return this.userId + ", " +this.password;
        return String.format("User(userId=%s, password=%s)", this.userId, this.password);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User) {
            User user = (User) obj;
            return this.userId.equals(user.userId);
        }
        
        return false;
    }
    @Override
    public int hashCode() {
        return userId.hashCode();
    }
    
}
