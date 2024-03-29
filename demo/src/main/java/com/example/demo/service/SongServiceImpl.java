package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.SongRepository;
import com.example.demo.model.Song;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song findById(int id) {
    	return songRepository.findById(id);
    }

	@Override
	public void saveSong(Song song) {
		songRepository.save(song);
	}

	@Override
	public void deleteSong(int id) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void deleteSong(int id) {
//		songRepository.deleteById(id);
//	}

}

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
