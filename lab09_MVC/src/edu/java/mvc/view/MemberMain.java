package edu.java.mvc.view;

import java.util.Scanner;

import edu.java.mvc.controller.MemberDaoImpl;
import edu.java.mvc.model.Member;

import static edu.java.mvc.controller.MemberDaoImpl.MAX_LENGTH;

// MVC(Model-View-Controller) 아키텍쳐를 사용한 회원 관리 프로그램
// 1. Model: 애플리케이션의 데이터를 설계한 클래스. Member
//  VO(Value Object), DTO(Data Transfer Object)
// 2. View: 애플리케이션의 UI(User Interface)를 담당하는 클래스. MemberMain.
// 3. Controller: 애플리케이션의 특정 로직, 기능을 담당하는 클래스. MemberDao.
//  DAO(Data Access Object)
//  - MemberDao 인터페이스.
//  - MemberDaoImpl 클래스 -> Single 패턴 적용.

public class MemberMain {
    
    private Scanner scanner = new Scanner(System.in);
    private MemberDaoImpl dao = MemberDaoImpl.getInstance();
    
    public static void main(String[] args) {
       System.out.println("*** 회원 관리 프로그램 ***");
       
       MemberMain app = new MemberMain();
       // -> MemberMain 객체의 non-static 멤버들을 사용하기 위해서.
       
       boolean run = true;
       while(run) {
           // TODO: 메뉴 보여주기           
           int n = app.chooseMenu();
           Menu menu = Menu.getValue(n);
           switch (menu) {
           case QUIT:
               run = false;
               break;
           case CREATE:
               app.createNewMember();
               break;
           case SELECT_ALL:
               app.select();
               break;
           case SELECT_BY_INDEX:
               app.selectByIndex();
               break;
           case UPDATE:
               app.updateMemberInfo();
               break;
           default:
               System.out.println("잘못된 메뉴 선택 - 메뉴를 다시 선택하세요.");
           }
       }
       
       System.out.println("*** 프로그램 종료 ***");
    } // end main
    
    private void updateMemberInfo() {
        System.out.println("--- 회원 정보 업데이트 ---");
        System.out.println("업데이트 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println("업데이트 비밀번호>>");
        String password = scanner.nextLine();
        
        // view(UI)에서 controller의 기능을 이용
        int result = dao.update(index, password);
        if(result == 1) {
            System.out.println("회원 정보 업데이트 성공");
        } else {
            System.out.println("회원 정보 업데이트 실패");
        }
    }
    
    private void selectByIndex() {
        System.out.println("--- 인덱스 검색 ---");
        System.out.print("검색할 인덱스>>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        // view(UI)에서 controller 기능을 사용
        Member m = dao.read(index);
        System.out.println(m);
    }

    private void select() {
        // view(UI)에서 controller 기능을 이용.
        Member[] members = dao.read();
        System.out.println("--- 회원 리스트 ---");
        for(Member m : members) {
            System.out.println(m);
        }
        System.out.println("------------------");
        
    }

    private void createNewMember() {
        System.out.println("----- 회원가입 -----");
        if(dao.getCount() == MAX_LENGTH) {
            System.out.println("회원 정보를 저장할 메모리가 부족합니다.");
            return; // 메서드 종료
        }
        
        System.out.println("아이디 입력>> ");
        String id = scanner.nextLine();
        System.out.println("비밀번호 입력>> ");
        String password = scanner.nextLine();
        
        Member m = new Member(id, password);
        // Member 타입 객체를 배열 저장 -> Controller 객체를 이용.
        int result = dao.creat(m);
        if (result == 1) {
            System.out.println("새로운 회원 정보 생성/저장 성공");
        } else {
            System.out.println("회원 정보 생성/저장 실패");
        }
    }
    
    private int chooseMenu() {
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("[0]종료 [1]회원가입 [2]전체검색 [3]인덱스검색 [4]업데이트");
        System.out.println("--------------------------------------------");
        System.out.print("선택> ");
        
        int n = Integer.parseInt(scanner.nextLine());
        
        return n;
    }
    
    
}
