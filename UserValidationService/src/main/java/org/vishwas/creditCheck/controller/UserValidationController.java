package org.vishwas.creditCheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vishwas.creditCheck.model.User;
import org.vishwas.creditCheck.model.UserEligibilityDetails;
import org.vishwas.creditCheck.service.UserCreditCheckService;

@CrossOrigin
@RestController
public class UserValidationController {
	
	@Autowired
	private UserCreditCheckService userCheckService;
	
    @RequestMapping(value="/check",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> checkValidUser(@RequestBody User userData) {
    	
		 try {
			  UserEligibilityDetails userEligibilityDetails = userCheckService.userValidation(userData);
			  return new ResponseEntity<>(userEligibilityDetails,HttpStatus.OK); 
		} catch (Exception e) {
			return  new ResponseEntity<>("User does not exist",HttpStatus.BAD_REQUEST);
		}
	}
}
