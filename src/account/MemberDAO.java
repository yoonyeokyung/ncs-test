package account;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MemberDAO {
	
	MemberDTO dto = new MemberDTO();
	MemberMain log = new MemberMain();
	
	FileOutputStream fsOut = null;
	ObjectOutputStream osOut = null;
	
	FileInputStream fsIn = null;
	ObjectInputStream osIn = null;

	public void insert(String id,String pw,String name, String gender, String addr) {
		
		MemberDTO insertMember = new MemberDTO(id,pw,name,gender,addr);

		try {
			if(new File("memberDB.txt").exists()) {
				fsOut = new FileOutputStream("memberDB.txt",true);
				osOut = new MyOutPutStream(fsOut);
			}else {
				fsOut = new FileOutputStream("memberDB.txt",true);
				osOut = new ObjectOutputStream(fsOut);
			}
			osOut.writeObject(insertMember);
			osOut.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fsOut != null) try{fsOut.close();}catch(IOException e){}
			if(osOut != null) try{osOut.close();}catch(IOException e){}	
			System.out.println("회원가입이 완료되었습니다!!");
			System.out.println(insertMember.getName() + "님 반갑습니다!");
		}

	}
	
	public void update(MemberDTO log, int logNum) throws IOException {
		fsIn = new FileInputStream("memberDB.txt");
		osIn = new ObjectInputStream(fsIn);
		
		while(true) {
			try {
				MemberDTO selectMember = (MemberDTO)osIn.readObject();
				
				if(log.equals(selectMember.getId()) && log.equals(selectMember.getPw())) {
					
					try {
						fsOut = new FileOutputStream("memberDB.txt",true);
						osOut = new ObjectOutputStream(fsOut);
						
//						if(logNum == 1) {
//						
//						}else if(logNum == 2) {
//							
//						}else if(logNum == 3) {
//							
//						}else if(logNum == 4) {
//							
//						}else if(logNum == 5) {
//							
//						}
						
					} catch (Exception e){
						e.printStackTrace();
					}

				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void delete(MemberDTO log) throws IOException {
		fsIn = new FileInputStream("memberDB.txt");
		osIn = new ObjectInputStream(fsIn);
		
		while(true) {
			try {
				MemberDTO selectMember = (MemberDTO)osIn.readObject();
				
				if(log.getId().equals(selectMember.getId()) && log.getPw().equals(selectMember.getPw())) {
					try {
						fsOut = new FileOutputStream("memberDB.txt",true);
						osOut = new ObjectOutputStream(fsOut);
					} catch (Exception e){
						e.printStackTrace();
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/* 여기서부터 select 부분 */
	// Login
	public int login(String id, String pw) throws IOException {
		fsIn = new FileInputStream("memberDB.txt");
		osIn = new ObjectInputStream(fsIn);
		int loginOnOff = 0;
		
		while(true) {
			try {
				MemberDTO selectMember = (MemberDTO)osIn.readObject();
				
				if(id.equals(selectMember.getId()) && pw.equals(selectMember.getPw())) {
					System.out.println("로그인 성공");
					loginOnOff ++;
					log.Login(selectMember);
					return loginOnOff;
				}
				
			} catch (Exception e) {
				System.out.println("ID 혹은 PW가 일치하지 않습니다.");
				return loginOnOff;
			}
		}

	}
	
	// searchID
	public void searchId(String name) throws IOException {
		fsIn = new FileInputStream("memberDB.txt");
		osIn = new ObjectInputStream(fsIn);
		
		while(true) {
			try {
				MemberDTO selectMember = (MemberDTO)osIn.readObject();
				
				if(name.equals(selectMember.getName())) {
					System.out.println("회원님의 아이디 : " + selectMember.getId());
					break;
				}
			
			} catch (Exception e) {
				System.out.println("일치하는 회원이 존재하지 않습니다.");
				break;
			}
		}
	}
	
	// searchPW
	public void searchPw(String id, String name) throws IOException {
		fsIn = new FileInputStream("memberDB.txt");
		osIn = new ObjectInputStream(fsIn);
		
		while(true) {
			try {
				MemberDTO selectMember = (MemberDTO)osIn.readObject();
				
				if(name.equals(selectMember.getName()) && id.equals(selectMember.getId())) {
					System.out.println("회원님의 비밀번호 : " + selectMember.getPw());
					break;
				}
				
			} catch (Exception e) {
				System.out.println("ID 혹은 이름이 일치하지 않습니다.");
				break;
			}
		}
	}


	
}
