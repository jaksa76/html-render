package me.jaksa.web.htmlrender;

import java.util.Collections;
import java.util.List;

/**
 * Created by Jaksa on 26/11/2017.
 */
public class Person {
    private final String name;
    private final String surname;
    private final List<Phone> phones;

    public Person(String name, String surname) {
        this(name, surname, Collections.emptyList());
    }

    public Person(String name, String surname, List<Phone> phones) {
        this.name = name;
        this.surname = surname;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
