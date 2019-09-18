package com.login.demo.controllers;

import java.util.Base64;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/login")
	public ResponseEntity<String> doLogin(HttpServletRequest request, HttpServletResponse response) {
		String loginCookie = (request.getCookies() == null || !request.getCookies()[0].getName().equalsIgnoreCase("login"))
				? Base64.getEncoder().encodeToString(new Date().toString().getBytes())
				: request.getCookies()[0].getValue();
		response.addCookie(new Cookie("login", loginCookie));
		return new ResponseEntity<String>("login success", HttpStatus.OK);
	}
}
