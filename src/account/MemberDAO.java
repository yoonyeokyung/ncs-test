package account;

import java.util.ArrayList;
import java.util.Arrays;

public class MemberDAO {
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String addr;
	
	MemberDTO dto = new MemberDTO();
	
	
	private ArrayList<String[]> memberList = new ArrayList<>(Arrays.asList(
			new String[][]{ {"ID","PW","이름","성별","주소"}, {"qwer","1234","홍길동","남","주소"} }));

	public void insert(String id, String pw, String name, String gender, String addr) {
		String[] insertArray = {id,pw,name,gender,addr};
		memberList.add(insertArray);
		
		/* 입력한 값이 잘 저장됐는지 확인 (ArrayList)*/
//		for (int i=0; i < memberList.size(); i++) {
//			for(int j=0; j<memberList.get(i).length; j++) {
//				System.out.print(memberList.get(i)[j].toString());
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
	}
	
	public void update(String id, String pw, String name, String gender, String addr) {
		
	}
	
	public void delete(String id, String pw) {
		
	}
	
	public void select(String id) {
		
	}
	
	public void searchId(String name) {
		for (int i=0; i < memberList.size(); i++) {
			if(memberList.get(i)[2].toString().equals(name)) {
				System.out.println(memberList.get(i)[0].toString());
				break;
			}else if((memberList.size()-1)==i){
				System.out.println("존재하지 않는 사용자");
			}
		}
	}
	
	public void searchPw(String id, String name) {
		for (int i=0; i < memberList.size(); i++) {
			if(memberList.get(i)[2].toString().equals(name) && memberList.get(i)[0].toString().equals(id)) {
				System.out.println(memberList.get(i)[1].toString());
				break;
			}else if((memberList.size()-1)==i){
				System.out.println("존재하지 않는 사용자이거나 존재하지 않는 ID");
			}
		}
	}
	
}
