package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.SongRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Song;

@Controller
public class UserController {

	@Autowired
	public UserRepository userRepo;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

//	private boolean isCurrentAuthenticationAnonymous() {
//	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	    return authenticationTrustResolver.isAnonymous(authentication);
//	}

}
