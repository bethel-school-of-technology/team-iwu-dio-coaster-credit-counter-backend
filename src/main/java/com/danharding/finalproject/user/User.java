package com.danharding.finalproject.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
	private @Id @GeneratedValue long id;
	private @NotBlank String firstName;
	private @NotBlank String lastName;
	private @NotBlank String email;
	private @NotBlank String username;
	private @NotBlank String password;
	private @NotBlank boolean loggedIn;

	public User() {

	}

	public User(@NotBlank String username, @NotBlank String password, @NotBlank String firstName,
			@NotBlank String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.loggedIn = false;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static boolean valPassword(String password) {
		if (password.length() > 7) {
			if(checkPassword(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("Password too short");
			return false;
		}
	}

	public static boolean checkPassword(String password) {
		boolean hasNum = false;
		boolean hasCap = false;
		boolean hasLow = false;
		char c;
		for (int i = 0; i < password.length(); i++) {
			c = password.charAt(i);
			if (Character.isDigit(c)) {
				hasNum = true;
			}
			if (Character.isUpperCase(c)) {
				hasCap = true;
			} else if (Character.isLowerCase(c)) {
				hasLow = true;
			}
			if (hasNum && hasCap && hasLow) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User user = (User) o;
		return Objects.equals(username, user.username) && Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, password, loggedIn);
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\''
				+ ", loggedIn=" + loggedIn + '}';
	}
}
