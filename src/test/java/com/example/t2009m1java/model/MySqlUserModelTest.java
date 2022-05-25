package com.example.t2009m1java.model;

import com.example.t2009m1java.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlUserModelTest {

    private MySqlUserModel model;
    @BeforeEach
    void setUp() {
        model = new MySqlUserModel();
    }

    @Test
    void save() {
        User user = new User("Cuong", "123", 1);
        assertEquals(true, model.save(user));

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }
}