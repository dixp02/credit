package org.vishwas.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.vishwas.main.controller.UserCreditCheckController;
import org.vishwas.main.model.User;

@Service
public class UserCreditCheckService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreditCheckController.class);

    
	public int creditEligibility(User user) {
		int age=user.getAge();
		int annualIncome=user.getAnnualIncome();
		int loanAmount=0;	
		LOGGER.debug("You are in creditEligibility method");
		if(age<18) {
			LOGGER.debug("Ur age is less than 18");
			return loanAmount;
		}
		
		else if((age>=18&&age<=40) && (annualIncome>=200000&&annualIncome<=1000000)) {
			LOGGER.debug("ur age is between 18-40");
			loanAmount=500000;
		}
			
		else if((age>=18&&age<=40) && (annualIncome>1000000)) {
			LOGGER.debug("ur age is between 18-40 and annual income is >1000000");
		    loanAmount=1500000;
			}
		else if(age>40&&annualIncome>1000000) {
			LOGGER.debug("ur age is >40");
			loanAmount=annualIncome/2;
		}
		LOGGER.debug("print the loan amount: "+loanAmount);
		return loanAmount;
	}
}
