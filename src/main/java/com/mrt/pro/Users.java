package com.mrt.pro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	private int uid;
	private String uname;
	private String usurname;
	private String umail;
	private String upassword;

	public Users() {
	}

	public Users(int uid, String uname, String usurname, String umail, String upassword) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.usurname = usurname;
		this.umail = umail;
		this.upassword = upassword;
	}
	
	@Id
	@Column(name = "uid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUsurname() {
		return usurname;
	}

	public void setUsurname(String usurname) {
		this.usurname = usurname;
	}

	public String getUmail() {
		return umail;
	}

	public void setUmail(String umail) {
		this.umail = umail;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

}
