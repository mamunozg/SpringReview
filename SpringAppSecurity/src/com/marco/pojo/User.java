package com.marco.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.marco.pojo.valid.SpringFormGroup;

@Entity
@Table(name = "user")
public class User {

//	private static final long serialVersionUID = 6612746195817544209L;

	@Id
	@GeneratedValue
	private int iduser;

	@NotEmpty(message=Constants.NOT_EMPTY, groups= {Persistence.class, SpringFormGroup.class})
	private String user;
	
	
	@NotEmpty(message=Constants.NOT_EMPTY, groups= {Persistence.class, SpringFormGroup.class})
	@Size(min=3, max=15, message=Constants.SIZE, groups= {SpringFormGroup.class})
	private String password;
	
	
	@NotEmpty(message=Constants.NOT_EMPTY, groups= {Persistence.class, SpringFormGroup.class})
	private String permission;
	
	
	private Timestamp creationDate;

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}


	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", user=" + user + ", password=" + password + ", permission=" + permission
				+ ", creationDate=" + creationDate + "]";
	}

}
