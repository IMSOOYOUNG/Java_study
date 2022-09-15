package edu.java.contact.ver02;

import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

// MVC 아키텍쳐에서 View(UI)에 해당하는 클래스
public class ContactMain02 {

    Scanner scanner = new Scanner(System.in);
    ContactDaoImpl dao = ContactDaoImpl.getInstance();  // 컨트롤러(연락처 저장, 검색, 수정) 클래스.
    
    public static void main(String[] args) {
        System.out.println("****** 연락처 프로그램 ******");
        
        ContactMain02 app = new ContactMain02();
        
        boolean run = true;
        
        while(run) {
            int n = app.showMainMenu();
            MainMenu menu = MainMenu.getValue(n);
            
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
            default:
                System.out.println("지원하지 않는 메뉴입니다. 다시 고르세요.");
            } // end switch문
            
        } // end while문
        
        System.out.println("****** 프로그램 종료 ******");
    } // end main

    private void updateContact() {
        System.out.println("수정할 인덱스 입력>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        if (!dao.isValidIndex(index)) {
            // 인덱스가 유효하지 않으면. (0보다 작거나 또는 저장된 연락처 개수보다 많다면)
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return; // 메서드 종료
        }
        
        Contact before = dao.read(index); // controller 메서드 사용해서 수정 전 데이터 읽어옴.
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
        System.out.println("이름 입력>> ");
        String name = scanner.nextLine();
        
        System.out.println("번호 입력>> ");
        String phone = scanner.nextLine();
        
        System.out.println("이메일 입력>> ");
        String email = scanner.nextLine();
        
        Contact con = new Contact(name, phone, email);
        int result = dao.create(con);
        if(result == 1) {
            System.out.println("새 연락처 저장 성공");
        } else {
            System.out.println("새 연락처 저장 실패");
        }
        
    }

    private void selectContactByIndex() {
        System.out.println("검색할 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        if (!dao.isValidIndex(index)) {
            // 인덱스가 유효하지 않으면, (0보닥 작거나 또는 저장된 연락처 개수보다 많다면)
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return; // 메서드 종료
        }
        
        Contact contact = dao.read(index);
        System.out.println(contact);
    }
    
    private void selectAllContacts() {   // 전체리스트
        System.out.println("회원 정보 출력");
        Contact[] contacts = dao.read();
        
        for(Contact c : contacts) {
            System.out.println(c);
        }
        System.out.println("---------------------");
    }
    
    private int showMainMenu() {    // 메뉴 보여주는 메서드
        System.out.println();
        System.out.println("---------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [0]종료");
        System.out.println("---------------------------------------------------------");
        System.out.println("메뉴 선택> ");
        int result = Integer.parseInt(scanner.nextLine());
        
        return result;
    }
    
} // end class
