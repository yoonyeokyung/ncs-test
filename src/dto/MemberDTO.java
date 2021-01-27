package dto;

import java.io.Serializable;
import java.util.Date;

public class MemberDTO implements Serializable{
	
	private static final long serialVersionUID = -4680769863667160271L;
	
	private String id;
	private String pw;
	private String name;
	private String birth;
	private char gender;
	private String addr;
	private Date regDate = new java.util.Date();
	
	public MemberDTO() {
		
	}

	public MemberDTO(String id, String pw, String name, String birth, char gender, String addr, Date regDate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.addr = addr;
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", gender=" + gender
				+ ", addr=" + addr + ", regDate=" + regDate + "]";
	}
	
	

}