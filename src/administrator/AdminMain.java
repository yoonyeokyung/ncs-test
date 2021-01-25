package administrator;

import java.io.IOException;
import java.util.Scanner;

public class AdminMain {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====관리자 메뉴=====");
		System.out.println("1. 회원목록조회");
		System.out.println("2. 상품관리");
		System.out.println("3. 영화관리");
		System.out.print("메뉴선택 : ");
		
		int num = sc.nextInt();
		sc.nextLine();
		
		MemberManage memberManage = new MemberManage();
		ProductInfo prodManage = new ProductInfo();
		
		// 메뉴 선택 시 실행되는 메소드
		switch(num) {
		case 1 : 
			//전체 회원 목록 조회
			memberManage.printMembers();
			break;
		case 2 : 
			prodManage.printList();
			break;
		case 3 :
			break;
		default : 
		}
		
		
		
	}

}
