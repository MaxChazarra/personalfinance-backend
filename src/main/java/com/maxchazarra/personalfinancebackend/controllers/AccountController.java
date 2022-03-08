package com.maxchazarra.personalfinancebackend.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxchazarra.personalfinancebackend.models.User;
import com.maxchazarra.personalfinancebackend.models.account.Account;
import com.maxchazarra.personalfinancebackend.repository.AccountRepository;
import com.maxchazarra.personalfinancebackend.repository.UserRepository;
import com.maxchazarra.personalfinancebackend.security.services.UserDetailsImpl;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	UserRepository userRepository;

	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllTutorials() {
		try {
			List<Account> tutorials = new ArrayList<Account>();

			accountRepository.findAll().forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getTutorialById(@PathVariable("id") long id) {
		Optional<Account> tutorialData = accountRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/accounts")
	public ResponseEntity<Account> createTutorial(@RequestBody Account tutorial, @AuthenticationPrincipal UserDetailsImpl user) {
		try {
			Account _tutorial = new Account(tutorial.getTitle(), tutorial.getDescription());

			Set<User> _users = new HashSet<>();
			User _user = userRepository.findByUsername(user.getUsername()).get();

			_users.add(_user);
			//_tutorial.setUsers(_users);

			_tutorial = accountRepository.save(_tutorial);
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/accounts/{id}")
	public ResponseEntity<Account> updateTutorial(@PathVariable("id") long id, @RequestBody Account tutorial) {
		Optional<Account> tutorialData = accountRepository.findById(id);

		if (tutorialData.isPresent()) {
			Account _tutorial = tutorialData.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			return new ResponseEntity<>(accountRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			accountRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/accounts")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			accountRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/accounts/user")
	public ResponseEntity<List<Account>> findByPublished(@AuthenticationPrincipal User user) {
		try {
			List<Account> accounts = accountRepository.findAll();

			if (accounts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(accounts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
