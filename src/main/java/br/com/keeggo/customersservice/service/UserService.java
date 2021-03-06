package br.com.keeggo.customersservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.keeggo.customersservice.model.repository.UserRepository;
import br.com.keeggo.customersservice.rest.exception.UserRegistryException;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	public br.com.keeggo.customersservice.model.entity.User save(br.com.keeggo.customersservice.model.entity.User user) {
		boolean exists = repository.existsByUsername(user.getUsername());
		if(exists) {
			throw new UserRegistryException(user.getUsername());
		}
		return repository.save(user);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		br.com.keeggo.customersservice.model.entity.User user = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Login not exists"));

		return User
				.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles("USER")
				.build();
	}
}