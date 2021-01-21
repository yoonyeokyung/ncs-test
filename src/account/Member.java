package account;

import java.util.Scanner;

public class Member {
	Scanner sc = new Scanner(System.in);
	MemberDTO dto = new MemberDTO();
	
	public void login() {
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.next();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw = sc.next();
		
		if(id.equals(dto.getId())) {
			if(pw.equals(dto.getPw())) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("아이디 혹은 비밀번호가 존재하지 않습니다.");				
			}
		}else {
			System.out.println("아이디 혹은 비밀번호가 존재하지 않습니다.");
		}
	}

	public void join() {
		//ID
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			dto.setId(id);
			
			if(dto.getId() != "" && dto.getId() != null) {
				break;
			}else {
				System.out.println("아이디를 입력해주세요.");
			}
		}
		//PW
		while(true) {
			while(true) {
				System.out.print("비밀번호 : ");
				String pw = sc.nextLine();
				dto.setPw(pw);
				
				if(dto.getPw() != "" && dto.getPw() != null) {
					break;
				}else {
					System.out.println("비밀번호를 입력해주세요");
				}
			}
			System.out.print("비밀번호확인 : ");
			String pw2 = sc.nextLine();
			
			if(dto.getPw().equals(pw2)) {
				break;
			}else {
				System.out.println("입력하신 비밀번호와 다릅니다.");
			}
		}
		//Name
		while(true) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			dto.setName(name);
			if(dto.getName() != "" && dto.getName() != null) {
				break;
			}else {
				System.out.println("이름을 입력해주세요.");
			}
		}
		//Gender
		while(true) {
			System.out.print("성별 (남, 여) : ");
			String gender = sc.nextLine();
			dto.setGender(gender);
			
			if(dto.getGender() != "" && dto.getGender() != null) {
				if(dto.getGender().equals("남") || dto.getGender().equals("여")) {
					break;
				}else {
					System.out.println("\'남\' 혹은 \'여\' 로만 입력해주세요.");
				}
			}else {
				System.out.println("성별을 입력해주세요.");
			}
		}
		//Addr
		while(true) {
			System.out.print("주소 : ");
			String addr = sc.nextLine();
			dto.setAddr(addr);
			
			if(dto.getAddr() != "" && dto.getAddr() != null) {
				break;
			}else {
				System.out.println("주소를 입력해주세요.");
			}
		}
		
		System.out.println("회원가입이 완료되었습니다!!");
	}

	public void searchId() {
		// TODO Auto-generated method stub
		
	}

	public void searchPw() {
		// TODO Auto-generated method stub
		
	}
}
