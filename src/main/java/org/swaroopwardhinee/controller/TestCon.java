package org.swaroopwardhinee.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCon {

	@PostMapping("/")
	public String test(@RequestHeader(name="Authorization") String aa) {
		System.out.println(aa);
		return "Test Success";
	}
}
