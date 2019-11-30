package ru.eltex.app.old_classes;

import java.io.Serializable;

public class Credentials implements Serializable {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String email;

    public Credentials(int id, String surname, String name,
                       String patronymic, String email) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "id:\"" + id + '"' +
                ", surname:\"" + surname + '"' +
                ", name:\"" + name + '"' +
                ", patronymic:\"" + patronymic + '"' +
                ", email:\"" + email + '"' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
