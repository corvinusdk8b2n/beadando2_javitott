package com.example.validatingforminput;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
public class Person
{
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    private String lastname;

    private String firstname;

    private String username;

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
        return "User{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}