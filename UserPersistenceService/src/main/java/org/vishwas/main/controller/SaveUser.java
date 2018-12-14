package org.vishwas.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vishwas.main.model.User;
import org.vishwas.main.service.PersistUser;

@RestController
public class SaveUser {
	
	@Autowired
	private PersistUser user;
	
	 @RequestMapping(value="/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<String>  persistNewUser(@RequestBody User userCreditEligibility){
	    	try{
	    		user.persistUser(userCreditEligibility);
	    		return new ResponseEntity<>("Successfully Saved",HttpStatus.OK); 
	    	}
	    	catch (Exception e) {
	    		return  new ResponseEntity<>("Make sure you send proper request",HttpStatus.BAD_REQUEST);
	    	}
	    }
}
