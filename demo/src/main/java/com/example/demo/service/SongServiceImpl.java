package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.SongRepository;
import com.example.demo.model.Song;

//@Service("SongService")
//@Transactional
//public class SongServiceImpl implements SongService{
//
//	@Autowired
//	SongRepository songRepo;
//	
//	@Override
//	public List<Song> findById(int id) {
//		return songRepo.findById(id);
//	}
//
//}
