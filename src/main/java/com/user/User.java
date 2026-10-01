package com.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String username;

        public User() {}

        public User(String username) {
            this.username = username;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getUsername() { return username; }

        @Override
        public String toString() {
            return String.format("User: id = %s, username = '%s'",id,username);
        }
}

