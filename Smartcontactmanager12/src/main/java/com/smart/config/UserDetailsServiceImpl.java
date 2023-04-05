package com.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.dao.Userrepository;
import com.smart.entites.User;

public class UserDetailsServiceImpl  implements UserDetailsService{
	
	@Autowired
	private Userrepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//fetching data from databsae
		
		User user=userrepository.getUserByUserName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("could not found user!!");
		}
		Customuserdetails customuserdetails=new Customuserdetails(user);
		return customuserdetails;
	}

}
