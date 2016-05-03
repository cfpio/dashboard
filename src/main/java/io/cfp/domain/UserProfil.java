package io.cfp.domain;

/**
 * Created by sguernion on 03/05/2016.
 */
public class UserProfil {

    private int id;
    private String mail;
    private String name;
    private String lastname;

    public UserProfil(String name, String lastname, String mail) {
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
    }

    public UserProfil(int id,String name, String lastname, String mail) {
        this(name,lastname,mail);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
