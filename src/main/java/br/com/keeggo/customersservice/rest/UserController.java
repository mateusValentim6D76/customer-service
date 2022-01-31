package br.com.keeggo.customersservice.rest;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.keeggo.customersservice.model.entity.User;
import br.com.keeggo.customersservice.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserRepository userRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody @Valid User user) {
		userRepository.save(user);
	}
}
