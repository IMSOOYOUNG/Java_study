package edu.java.contact.ver03;

import java.util.ArrayList;
import java.util.List;

import edu.java.contact.ver02.Contact;

public class ContactDaoImpl implements ContactDao{
   
    // field
    private List<Contact> list = new ArrayList<>();
    
    // 생성자(Constructor)
    private ContactDaoImpl() {};
    private static ContactDaoImpl instance = null;
    public static ContactDaoImpl getInstance() {
        if(instance == null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }
    
    // method
    @Override
    public List<Contact> read() {
        return list;
    }

    @Override
    public Contact read(int index) {

        if(!isValidIndex(index)) {
            return null;
        }else {
            return list.get(index);
        }
    }

    @Override
    public int creat(Contact contact) {
        int result;
        if(list.add(contact)) {
            result = 1;
        }else {
            result = 0;
        }
        return result;
    }

    @Override
    public int update(int index, Contact contact) {
        list.set(index, contact);
        return 1;
    }

    @Override
    public int delete(int index) {
        list.remove(index);
        return 1;
    }
    
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < list.size());
    }

}
