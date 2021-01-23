package account;

import java.io.Serializable;

public class MemberDTO implements Serializable{

	private static final long serialVersionUID = -7034443345777681227L;
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String addr;
	
	public MemberDTO() {

	}
	
	public MemberDTO(String id, String pw, String name, String gender, String addr) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.addr = addr;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", addr=" + addr + "]";
	}
	
	
	
}
