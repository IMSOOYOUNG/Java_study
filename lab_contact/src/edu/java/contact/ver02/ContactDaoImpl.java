package edu.java.contact.ver02;

// MVC 아키텍쳐에서 Controller (구현) 클래스
public class ContactDaoImpl implements ContactDao {

    private static final int MAX_LENGTH = 3;
    
    private Contact[] contactList = new Contact[MAX_LENGTH];
    
    private int count = 0;
    
    // 생성자 - 싱글톤 
    private ContactDaoImpl() {};
    private static ContactDaoImpl instance = null;  
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
           instance = new ContactDaoImpl(); 
        }
        return instance;
    }
    
    
    @Override
    public Contact[] read() {
        Contact[] contacts = new Contact[count];
        for(int i = 0; i < count; i++) {
            contacts[i] = contactList[i];
        }
        return contacts;
    }

    @Override
    public Contact read(int index) {
        if(index >= 0 && index < MAX_LENGTH) {
            return contactList[index];
        } else {
            return null;
        }
        
    }

    @Override
    public int create(Contact contact) {
        if(count >= MAX_LENGTH) {
            return 0;
        }
        
        contactList[count] = contact; 
        count++;
        return 1;
    }

    @Override
    public int update(int index, Contact c) {
        if(index < 0 && index > count) {
            return 0;
        } else {
            contactList[index].setName(c.getName());
            contactList[index].setPhone(c.getPhone());
            contactList[index].setEmail(c.getEmail());
            return 1;
        }
    }
    
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < count);
    }
    
    public boolean isMemoryAvailable() {
        return count < MAX_LENGTH;
    }

}
