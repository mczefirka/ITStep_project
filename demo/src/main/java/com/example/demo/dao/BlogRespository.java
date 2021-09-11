package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Blog;

@Repository
public interface BlogRespository extends JpaRepository<Blog, Integer>{
	List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);
}
