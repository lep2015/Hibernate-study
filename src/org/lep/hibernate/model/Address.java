package org.lep.hibernate.model;

import java.util.Set;

/**
 * Created by lvep on 2016/3/21.
 */
public class Address {
    private long id;
    private Set<Person> people;
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
