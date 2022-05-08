package com.example.validatingforminput;

import javax.validation.constraints.*;

public class PersonForm {

	@NotNull
	private String lastname;

	@NotNull
	private String firstname;

	@NotNull
	@Size(min = 6)
	private String username;

	@NotNull
	@Size(min = 8)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
	private String password;

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "PersonForm{" +
				"lastname='" + lastname + '\'' +
				", firstname='" + firstname + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
