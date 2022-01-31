package br.com.keeggo.customersservice.rest.exception;

public class UserRegistryException extends RuntimeException {

	public UserRegistryException(String login) {
		super("user already registered" + login);
	}
}
