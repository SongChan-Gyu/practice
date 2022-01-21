package com.example.testing.jpa.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository  extends JpaRepository<Posts, Long> {
}
