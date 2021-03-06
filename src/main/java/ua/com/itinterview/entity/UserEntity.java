package ua.com.itinterview.entity;

import javax.persistence.*;

import ua.com.itinterview.web.command.UserCommand;
import ua.com.itinterview.web.command.UserEditProfileCommand;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "sequence", sequenceName = "users_id", allocationSize = 1)
public class UserEntity extends EntityWithId {

    @Column(unique = true)
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    private String name;
    @Enumerated(EnumType.STRING)
    private Sex sex;

    public UserEntity() {

    }

    public UserEntity(UserCommand userCommand) {
	userName = userCommand.getUserName();
	password = userCommand.getPassword();
	email = userCommand.getEmail();
	name = userCommand.getName();
	sex = userCommand.getSex();
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public Sex getSex() {
	return sex;
    }

    public void setSex(Sex sex) {
	this.sex = sex;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result
		+ ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((sex == null) ? 0 : sex.hashCode());
	result = prime * result
		+ ((userName == null) ? 0 : userName.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	UserEntity other = (UserEntity) obj;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (password == null) {
	    if (other.password != null)
		return false;
	} else if (!password.equals(other.password))
	    return false;
	if (sex == null) {
	    if (other.sex != null)
		return false;
	} else if (!sex.equals(other.sex))
	    return false;
	if (userName == null) {
	    if (other.userName != null)
		return false;
	} else if (!userName.equals(other.userName))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "UserEntity [userName=" + userName + ", password=" + password
		+ ", email=" + email + ", name=" + name + ", sex=" + sex + "]";
    }

    public enum Sex {
	MALE, FEMALE;

	public String getValue() {
	    return name();
	}

	public void setValue(String value) {
	}
    }

}
