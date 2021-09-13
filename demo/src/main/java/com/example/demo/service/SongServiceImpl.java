package com.example.demo.service;

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
