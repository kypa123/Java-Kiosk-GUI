package store;

import java.util.Scanner;

public class Menu {
	Admin admin;
	User user;
	
	void loginMenu(Scanner scan) {
		while(true) {
			System.out.print("id : ");
			String id = scan.next();
			System.out.print("pwd : ");
			String pwd = scan.next();
			
			//어드민인지 확인 -> 어드민이면 어드민 메뉴로
			admin = Store.adminMgr.find(id);
			if(admin != null) {
				if(admin.passwordMatch(pwd)) {
					AdminMenu(scan);
					continue;
				}
			}
			
			//유저인지 확인 -> 유저면 유저메뉴로
			user = Store.userMgr.find(id);
			if(user != null) {
				if(user.passwordMatch(pwd)) {
					UserMenu(scan);
					continue;
				}
			}
			//아무것도 아니라면 계속 반복문 돌게...
			System.out.println("id와 pwd를 다시 확인해주세요.");
			flushLoginBuffer();
		}
						
	}
	
	void UserMenu(Scanner scan) {
		int num;
		while(user != null) {
			System.out.print("(0) 로그아웃 ");
			num = scan.nextInt();
			switch(num) {
			case 0:
				flushLoginBuffer();
				break;
			default: break;
			}
		}
	}
	
	void AdminMenu(Scanner scan) {
		int num;
		while(admin != null) {
			System.out.print("(1)물품출력 (2)사용자출력 (3)주문출력 (4)검색 (0)로그아웃 ");
			num = scan.nextInt();
			switch(num) {
			case 0:
				flushLoginBuffer();
				break;
			case 1: Store.itemMgr.printAll(); break;
			case 2: Store.userMgr.printAll(); break;
			case 3: Store.orderMgr.printAll(); break;
			case 4: searchMenu(scan); break;
			default : break;
			}
		}
	}
	
	void searchMenu(Scanner scan) {
		int num;
		while (true) {
			System.out.print("(1)물품검색 (2)사용자검색 (3)주문검색 (기타) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 3) break;
			switch(num) {
			case 1: Store.itemMgr.searchAll(scan); break;
			case 2: Store.userMgr.searchAll(scan); break;
			case 3: Store.orderMgr.searchAll(scan); break;
			default: break;
			}
		}
	}
	
	void flushLoginBuffer() {
		user = null;
		admin = null;
	}
}