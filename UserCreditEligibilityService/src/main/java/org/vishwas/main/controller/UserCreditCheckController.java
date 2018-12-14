package org.vishwas.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vishwas.main.model.User;
import org.vishwas.main.service.UserCreditCheckService;

@RestController
public class UserCreditCheckController {
	
	@Autowired
	private UserCreditCheckService userCheckService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreditCheckController.class);
    
	
    @RequestMapping(value="/eligibilityCheck",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public int checkForCreditEligibility(@RequestBody User userCreditEligibility){
    	LOGGER.debug("Hi you are in credit check controller");
    	return userCheckService.creditEligibility(userCreditEligibility);
    }
}
