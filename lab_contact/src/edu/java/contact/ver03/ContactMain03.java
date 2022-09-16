package edu.java.contact.ver03;

import java.util.List;
import java.util.Scanner;

import edu.java.contact.menu.MainMenu;
import edu.java.contact.ver02.Contact;

public class ContactMain03 {
    
    Scanner scanner = new Scanner(System.in);
    ContactDaoImpl dao = ContactDaoImpl.getInstance();
    
    public static void main(String[] args) {    
        
        System.out.println("***** 연락처 프로그램 *****");
        ContactMain03 app = new ContactMain03(); 
        
        boolean run = true;
        while(run) {
            int n   = app.showMain();
            MainMenu menu   = MainMenu.getValue(n);
            
            switch(menu) {
            case QUIT:
                run = false;
                break;
            case SELECT_ALL:
                app.selectAllContacts();
                break;
            case SELECT_BY_INDEX:
                app.selectContactByIndex();
                break;
            case CREAT:
                app.insertNewContact();
                break;
            case UPDATE:
                app.updateContact();
                break;
            case DELETE:
                app.deleteContact();
                break;
            default:
                System.out.println("지원하지 않는 메뉴입니다. 다시 고르세요.");
            } // end switch문
            
        } // end while문
        System.out.println("***** 프로그램 종료 *****");
        
    }   // end main()

    private void deleteContact() {
        System.out.println("삭제할 인덱스를 입력하세요.");
        
        int index;
        while(true) {
            try {
                index = Integer.parseInt(scanner.nextLine());
                break;
            }catch(NumberFormatException e) {
                System.out.println("번호를 입력하세요.");
            }
        }
        
        if(!dao.isValidIndex(index)) {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        }
        int result = dao.delete(index);
        System.out.println("삭제 성공.");
    }

    private void updateContact() {
        System.out.print("수정할 인덱스 입력>> ");
        int index;
        
        while(true) {
            try {
                index = Integer.parseInt(scanner.nextLine());
                break;
            }catch(NumberFormatException e) {
                System.out.println("번호를 입력하세요.");
            }
        }
        
        if(!dao.isValidIndex(index)) {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        }
        
        Contact before = dao.read(index);
        System.out.println("수정 전: " + before);
        
        System.out.println("수정할 이름 입력>> ");
        String name = scanner.nextLine();
        
        System.out.println("수정할 번호 입력>> ");
        String phone = scanner.nextLine();
        
        System.out.println("수정할 이메일 입력>> ");
        String email = scanner.nextLine();
        
        Contact after = new Contact(name, phone, email);
    
        int result = dao.update(index, after);
        
        if(result == 1) {
            System.out.println("수정 성공");
        }else {
            System.out.println("수정 실패");
        }
    }
    
    private void insertNewContact() {
        System.out.print("이름 입력>>");
        String name = scanner.nextLine();
        
        System.out.print("번호 입력>>");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 입력>>");
        String email = scanner.nextLine();
        
        Contact con = new Contact(name, phone, email);
        int result  = dao.creat(con);
        if(result == 1) {
            System.out.println("성공");
        }else {
            System.out.println("실패");
        }
    }
    
    private void selectContactByIndex() {
        System.out.println("검색할 인덱스>> ");
        
        int index;
        while(true) {
            try {
                index = Integer.parseInt(scanner.nextLine());
                break;
            }catch(NumberFormatException e) {
                System.out.println("번호를 입력하세요.");
            }
        }
        
        Contact result = dao.read(index);
        
        System.out.println(result);
    }

    private void selectAllContacts() {
        System.out.println("회원 정보 출력");
        List<Contact> contacts = dao.read();
        for(Contact c : contacts) {
            System.out.println(c);
        }
        System.out.println("-------------------------------");
    }

    private int showMain() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [5]삭제 [0]종료");
        System.out.println("---------------------------------------------------------------");
        System.out.println("메뉴 선택>");
        
        int result;
        while(true) {
            try {
                result = Integer.parseInt(scanner.nextLine());
                break;
            }catch(NumberFormatException e) {
                System.out.println("번호를 입력하세요.");
            }
        }
        return result;
    }
    
}   // end class
