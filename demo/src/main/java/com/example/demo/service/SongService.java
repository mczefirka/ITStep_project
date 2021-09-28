package com.example.demo.service;

import com.example.demo.model.Song;

public interface SongService {
	Song findById(int id);
    void saveSong(Song song);
    void deleteSong(int id);
}
