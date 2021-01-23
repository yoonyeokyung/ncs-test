package administrator;

import java.util.ArrayList;

public class MemberManage {
	
	public void printMembers() {
		
		ArrayList<String[]> member = new ArrayList<String[]>();
		member.add(new String[] {"honggd", "hong01", "홍길동", "남", "경기"});
		member.add(new String[] {"yougs", "you02", "유관순", "여", "서울"});
		member.add(new String[] {"leess", "lee03", "이순신", "남", "경기"});
		member.add(new String[] {"sinsid", "sin04", "신사임당", "여", "서울"});
		member.add(new String[] {"yoonbg", "yoon05", "윤봉길", "남", "부산"});
		
		for(int i = 0; i < member.size(); i++) {             
			System.out.print("ID : " + member.get(i)[0] + "\t");
			System.out.print("PW : " + member.get(i)[1] + "\t");
			System.out.print("이름 : " + member.get(i)[2] + "\t");
			System.out.print("성별 : " + member.get(i)[3] + "\t");
			System.out.print("지역 : " + member.get(i)[4]);
			System.out.println();
			}
		}
}
