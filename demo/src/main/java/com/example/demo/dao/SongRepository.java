package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{
//	Optional<Song> findById(Integer id);
}
