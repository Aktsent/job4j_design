package ru.job4j.generics;

public class Role extends Base {

    private final String surname;

    public Role(String id, String surname) {
        super(id);
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }
}
