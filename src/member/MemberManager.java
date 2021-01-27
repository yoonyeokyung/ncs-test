package member;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberManager {
	
	MemberDAO dao = new MemberDAO();
	
	public MemberDTO login(String id, String pw) {
		
		MemberDTO login = dao.login(id, pw);
		return login;
	}

	public boolean join(String id, String pw, String name, String birth, char gender, String addr) {
		
		MemberDTO insert = new MemberDTO(id,pw,name,birth,gender,addr, new java.util.Date());
		boolean yesNo = dao.insert(insert);
		
		return yesNo;
	}

	public String searchId(String name) {
		
		String searchId = dao.searchId(name);
		return searchId;
	}
	
	public String searchPw(String name, String id) {
		
		String searchPw = dao.searchPw(name, id);
		return searchPw;
	}

	public void delete(MemberDTO memberInfo) {
		
		dao.delete(memberInfo);
	}

	public void update(MemberDTO memberInfo) {
		
		dao.update(memberInfo);
	}

	public boolean doubleCheck(String id) {
		
		boolean yesNo = dao.doubleCheck(id);
		return yesNo;
	}
	
}