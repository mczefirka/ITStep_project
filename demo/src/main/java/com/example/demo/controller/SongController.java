package com.example.demo.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SongRepository;
import com.example.demo.model.Blog;
import com.example.demo.model.Song;

@Controller
public class SongController {
	
	@Autowired
	private SongRepository songRepo;
	
    @GetMapping("/songList")
    public String viewSongList(Model model) {
 
        model.addAttribute("songs", songRepo.findAll());
 
        return "songList";
    }
    
    @GetMapping("/song/{id}")
    public String show(@PathVariable String id, Model model){
        int songId = Integer.parseInt(id);
        
        model.addAttribute("song", songRepo.getById(songId));
        
        return "song";
    }
    
//    @PutMapping("/song_edit/{id}")
//    public Song update(@PathVariable String id, @RequestBody Map<String, String> body) {
//        int songId = Integer.parseInt(id);
//        
////        Blog blog = blogRespository.getById(blogId);
////        blog.setTitle(body.get("title"));
////        blog.setContent(body.get("content"));
////        return blogRespository.save(blog);
//    }
    
}
