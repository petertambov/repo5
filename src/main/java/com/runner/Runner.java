package com.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.user.User;
import com.repository.UserRepository;
import com.userservice.UserService;


@Component
public class Runner implements CommandLineRunner {

    private final UserService userService;

    public Runner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        User testUser2 = userService.createUser("TestUser2");
        System.out.printf("Создан пользователь: %s%n", testUser2);

        User testUser3 = userService.createUser("TestUser3");
        System.out.printf("Создан пользователь: %s%n", testUser3);

        User testUserX = userService.getUserById(testUser3.getId());
        System.out.printf("Получен пользователь по id: %s%n", testUserX.getId());

        userService.getAllUsers().forEach(System.out::println);

        userService.deleteUser(testUserX.getId());
        System.out.printf("Пользователь %s удалён.%n", testUserX.getUsername());

        System.out.println("После удаления:");
        userService.getAllUsers().forEach(System.out::println);

        userService.findByUsername("Admin")
                .ifPresentOrElse(System.out::println, () -> System.out.println("Пользователь с именем 'Admin' не найден"));

        userService.findByUsernameStartingWith("A").forEach(u -> System.out.printf("Пользователи, имя которых начинается с 'A' :%s%n", u));
    }
}