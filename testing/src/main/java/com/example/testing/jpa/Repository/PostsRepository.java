package com.example.testing.jpa.Repository;

import com.example.testing.jpa.Domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository  extends JpaRepository<Posts, Long> {
}
