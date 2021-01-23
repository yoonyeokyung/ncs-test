package account;

import java.io.IOException;
import java.util.Scanner;

public class Member {
	Scanner sc = new Scanner(System.in);
	MemberDTO dto = new MemberDTO();
	MemberDAO dao = new MemberDAO();
	
	public int login() {
		int login = 0;
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.next();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw = sc.next();
		
		try {
			login = dao.login(id, pw);
			return login;
			
		} catch (IOException e) {
			e.printStackTrace();
			return login;
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
		
		dao.insert(dto.getId(),dto.getPw(),dto.getName(),dto.getGender(),dto.getAddr());
	}

	public void searchId() {
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		try {
			dao.searchId(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void searchPw() {
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		try {
			dao.searchPw(id, name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(MemberDTO log) throws IOException {
		System.out.println("1. id : " + log.getId());
		System.out.println("2. pw : " + log.getPw());
		System.out.println("3. name : " + log.getName());
		System.out.println("4. gender : " + log.getGender());
		System.out.println("5. addr : " + log.getAddr());		
		System.out.println("0. 취소하기");
		
		System.out.print("수정할 번호를 입력해주세요 : ");
		int no = sc.nextInt();
		switch(no) {
		case 1 : dao.update(log, 1); break;
		case 2 : dao.update(log, 2); break;
		case 3 : dao.update(log, 3); break;
		case 4 : dao.update(log, 4); break;
		case 5 : dao.update(log, 5); break;
		case 0 : System.out.println("취소되었습니다."); break;
		default : System.out.println("잘못된 번호가 입력됐습니다.");
		}
//		dao.update(log);
	}

	public void delete(MemberDTO log) throws IOException {
		dao.delete(log);
	}


}
