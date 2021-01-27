package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import member.MyOutPutStream;
import dto.MemberDTO;
import run.MemberMain;

public class MemberDAO {
	
	ObjectOutputStream osOut = null;
	ObjectInputStream osIn = null;

	/* insert */
	public boolean insert(MemberDTO insertMember) {
		
		boolean yesNo = true;

		try {
			if(new File("DB/memberDB.txt").exists()) {
				osOut = new MyOutPutStream(new BufferedOutputStream(new FileOutputStream("DB/memberDB.txt",true)));
			}else {
				osOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/memberDB.txt",true)));
			}
			osOut.writeObject(insertMember);
			osOut.flush();
		} catch (Exception e) {
			e.printStackTrace();
			yesNo = false;
		} finally {
			if(osOut != null) try{osOut.close();}catch(IOException e){}	
		}
		
		return yesNo;
		
	}
	
	/* update */
	public void update(MemberDTO memberInfo) {

		ArrayList<MemberDTO> dummy = new ArrayList<MemberDTO>();
		
		try {
			osIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/memberDB.txt")));
			
			while(true) {
				MemberDTO updateMember = (MemberDTO)osIn.readObject();
				if(memberInfo.getId().equals(updateMember.getId())) {
					dummy.add(memberInfo);		
				}else {
					dummy.add(updateMember);
				}	
			}
		} catch (EOFException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(osIn != null) try{osIn.close();}catch(IOException e){}	
		}
		
		try {
			osOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/memberDB.txt",false)));
			
			for(MemberDTO object : dummy) {
				osOut.writeObject(object);
				osOut.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			if(osOut != null) try{osOut.close();}catch(IOException e){}	
		}
		
	}
	
	/* delete */
	public void delete(MemberDTO memberInfo) {

		ArrayList<MemberDTO> dummy = new ArrayList<MemberDTO>();
		
		try {
			osIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/memberDB.txt")));
			
			while(true) {
				MemberDTO deleteMember = (MemberDTO)osIn.readObject();
				if(memberInfo.getId().equals(deleteMember.getId()) && memberInfo.getPw().equals(deleteMember.getPw())) {
					continue;				
				}else {
					dummy.add(deleteMember);
				}	
			}
		} catch (EOFException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(osIn != null) try{osIn.close();}catch(IOException e){}	
		}
		
		try {
			osOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/memberDB.txt",false)));
			
			for(MemberDTO object : dummy) {
				osOut.writeObject(object);
				osOut.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			if(osOut != null) try{osOut.close();}catch(IOException e){}	
		}
		
	}
	
	/* 여기서부터 select 부분 */
	public ArrayList<MemberDTO> Member () {
		ArrayList<MemberDTO> member = new ArrayList<>();
		try {
			osIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/memberDB.txt")));
			
			while(true) {
				MemberDTO selectMember = (MemberDTO)osIn.readObject();
				member.add(selectMember);
			}
			
		} catch (EOFException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(osIn != null) try{osIn.close();}catch(IOException e){}	
		}
		return member;
	}
	
	// Login
	public MemberDTO login(String id, String pw) {
		
		MemberDTO loginOnOff = null;

		for(MemberDTO m : Member()) {
			if(m.getId().equals(id) && m.getPw().equals(pw)) {
				loginOnOff = m;
			}
		}

		return loginOnOff;
	}
	
	// searchID
	public String searchId(String name) {
		
		String searchId = null;
			
		for(MemberDTO m : Member()) {
			if(name.equals(m.getName())) {
				searchId = m.getId();
			}
		}
			
		return searchId;
	}
	
	// searchPW
	public String searchPw(String name, String id) {
		
		String searchPw = null;
			
		for(MemberDTO m : Member()) {
			if(name.equals(m.getName()) && id.equals(m.getId())) {
				searchPw = m.getPw();
			}
		}
			
		return searchPw;
	}

	public boolean doubleCheck(String id) {
		boolean yesNo = false;
		
		for(MemberDTO m : Member()) {
			if(id.equals(m.getId())) {
				yesNo = true;
			}
		}
		
		return yesNo;
	}
	
}
