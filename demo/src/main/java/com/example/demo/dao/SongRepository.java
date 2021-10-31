package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, String>{
	Song findById(int id);
	List<Song> findByIdContainingOrSongNameContaining(String text, String textAgain);
}