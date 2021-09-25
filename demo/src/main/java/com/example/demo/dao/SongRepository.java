package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{
	Song findById(int id);
}
