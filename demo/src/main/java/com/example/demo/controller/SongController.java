package com.example.demo.controller;


import java.util.Map;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GenreRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.SongRepository;
import com.example.demo.model.Blog;
import com.example.demo.model.Song;
import com.example.demo.service.SongService;

@Controller
public class SongController {
	
	@Autowired
	private SongRepository songRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private SongService songService;
	
	@Autowired
	private GenreRepository genreRepo;	
	
    @GetMapping("/songList")
    public String viewSongList(Model model) {
 
        model.addAttribute("songs", songRepo.findAll());
 
        return "songList";
    }
    
    @GetMapping({"/song/{id}", "/song?id={id}"})
    public String show(@PathVariable String id, Model model){
        int songId = Integer.parseInt(id);
        
        model.addAttribute("song", songRepo.getById(songId));
        
        return "song";
    }
    
	@GetMapping("/addSong")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@Temporal(TemporalType.TIMESTAMP)
	public String saveSong(Model model) {

		model.addAttribute("newSong", new Song());

		model.addAttribute("genres", genreRepo.findAll());

		return "addSong";
	}
    
    @PostMapping("/addSong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.TIMESTAMP)
    public String saveSong(@ModelAttribute("newSong") Song newSong) {
        
        songService.saveSong(newSong);
 
        return "redirect:/welcome";
    }
    
	@DeleteMapping("/deleteSong/{id}")
	public String deleteSong(@PathVariable String id) {
		
		int songId = Integer.parseInt(id);
		songService.deleteSong(songId);

		return "redirect:/songList";
		
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
