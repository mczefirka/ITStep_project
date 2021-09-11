package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.Role;
import com.example.demo.model.User;

public class UserDetailsServiceImpl implements UserDetailsService{
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    @Transactional(readOnly = true)
	    public UserDetails loadUserByUsername(String username) {
	        User user = userRepository.findByUsername(username);
	        if (user == null) throw new UsernameNotFoundException(username);

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (Role role : user.getRoles()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }

	        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), grantedAuthorities);
	    }
}
