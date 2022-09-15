package edu.java.contact.ver02;

// MVC 아키텍쳐에서 Controller의 인터페이스 - 메서드 선언
public interface ContactDao {
    
    /**
     *  전체리스트 검색
     */
    Contact[] read();
    
    /**
     * 인덱스 검색
     */
    Contact read(int index);
    
    /**
     * 새연락처
     */
    int create(Contact contact);
    
    /**
     * 수정
     */
    int update(int index, Contact contact);
    
}
