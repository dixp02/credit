package org.vishwas.creditCheck.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vishwas.creditCheck.DAO.AccountCheckDAO;
import org.vishwas.creditCheck.DAO.UserCreateDAO;
import org.vishwas.creditCheck.model.User;
import org.vishwas.creditCheck.model.UserEligibilityDetails;

@Service
public class UserCreditCheckService {

	@Autowired
	private UserCreateDAO userRepository;
	@Autowired
	private AccountCheckDAO accountRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserCreditCheckService.class);
	public UserCreateDAO getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserCreateDAO userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserEligibilityDetails prepareEligibilityDetails(User user, int loanAmount, int balance, String userExists) {
		UserEligibilityDetails userEligibilityDetails = new UserEligibilityDetails();

		userEligibilityDetails.setFirstName(user.getFirstName());
		userEligibilityDetails.setLastName(user.getLastName());
		userEligibilityDetails.setLoanAmount(loanAmount);
		if (loanAmount == 0) {
			userEligibilityDetails.setEligibilityStatus("NOT ELIGIBLE");
		} else {
			userEligibilityDetails.setEligibilityStatus("ELIGIBLE");
		}
		if (balance != 0) {
			userEligibilityDetails.setOutstandingBalance(balance);
		}
		userEligibilityDetails.setUserExists(userExists);
		return userEligibilityDetails;
	}

	public UserEligibilityDetails userValidation(User user) throws Exception {
		User userExisting;
		int loanAmount = 0;
		int balance = 0;
		String userExists = null;
		LOGGER.debug("Print User Repository:" + userRepository.toString());
		LOGGER.debug("Print User Object:" + user.toString());
		ResponseEntity<Integer> responseEntity = new RestTemplate()
				.postForEntity("http://localhost:8081/eligibilityCheck", user, Integer.class);

		loanAmount = responseEntity.getBody();
		userExisting = userRepository.findByEmail(user.getMailId());

		if (userExisting != null) {
			LOGGER.debug("Printintg userID:" + userExisting.getUserId());
			LOGGER.debug("Print Account Details Success:"
					+ accountRepository.findAccountByUserId(userExisting.getUserId()).getAccountNumber());
			balance = accountRepository.findAccountByUserId(userExisting.getUserId()).getOutStanding();
			userExists = "USER EXISTS";
			return prepareEligibilityDetails(userExisting, loanAmount, balance, userExists);
		} else {
			userExists = "USER DOES NOT EXIST";
			return prepareEligibilityDetails(user, loanAmount, balance, userExists);
		}
	}
}