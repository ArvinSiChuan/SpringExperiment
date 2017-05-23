package com.springexperiment.beans.authHandlers;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customerUserDetails")
public class CustomerUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		System.out.println("**********************************************************");
		System.out.println("827CCB0EEA8A706C4C34A16891F84E7B"); // md5 for 12345
		return null;
	}

}
