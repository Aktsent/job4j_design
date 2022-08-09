package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoleStoreTest {

    @Test
    void add() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Novak"));
        Role rsl = store.findById("1");
        assertThat(rsl.getSurname()).isEqualTo("Novak");
    }

    @Test
    void replace() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Still"));
        store.replace("1", new Role("1", "Hofman"));
        Role rsl = store.findById("1");
        assertThat(rsl.getSurname()).isEqualTo("Hofman");
    }

    @Test
    void delete() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Still"));
        store.delete("1");
        Role rsl = store.findById("1");
        assertThat(rsl).isNull();
    }

    @Test
    void findById() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sax"));
        Role rsl = store.findById("1");
        assertThat(rsl.getId()).isEqualTo("1");
    }
}