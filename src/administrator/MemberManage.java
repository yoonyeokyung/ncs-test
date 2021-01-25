package administrator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import dto.MemberDTO;

public class MemberManage {
	
	FileInputStream fsIn = null;
	ObjectInputStream osIn = null;
	
	public void printMembers() throws IOException {
	
	fsIn = new FileInputStream("memberDB.txt");
	osIn = new ObjectInputStream(fsIn);
		
	while(true) {
		try {
			MemberDTO printall = (MemberDTO)osIn.readObject();
			
			System.out.println("ID \t이름 \t성별 \t주소");
			System.out.print(printall.getId() + "\t" + printall.getName() + "\t" + 
									printall.getGender() + "\t" + printall.getAddr());
			System.out.println("");
			System.out.println("");
			
		} catch (Exception e) {
			break;
		}
	}
	}
}
