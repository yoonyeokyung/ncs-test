package account;

import java.util.Scanner;

public class MemberMain {
	
	MemberDTO dto = new MemberDTO();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member member = new Member();
		int no;
		
		while(true) {
			System.out.println("원하는 명령을 선택하세요.");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 아이디 찾기");
			System.out.println("4. 비밀번호 찾기");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("입력 : ");
			no = sc.nextInt();
			
			switch(no) {
				case 1 : 
					member.join();
					break;
				case 2 : {
					if(member.login() == 1) {
						while(true) {
							System.out.println("원하는 명령을 선택하세요.");
							System.out.println("1. 회원정보수정");
							System.out.println("2. 회원탈퇴");
							System.out.println("0. 로그아웃");
							
							System.out.print("입력 : ");
							no = sc.nextInt();
							switch(no) {
								case 1 : 
									member.update();
									break;
								case 2 : 
									member.delete();
									break;
								case 0 : return;
								default : System.out.println("잘못된 번호 입력");
							}
						}
					}else {
						break;
					}
				}
				case 3 :
					member.searchId();
					break;
				case 4 :
					member.searchPw();
					break;
				case 0 : return;
				default : System.out.println("잘못된 번호 입력");
			}
		}

	}

}

