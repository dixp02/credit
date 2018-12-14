package org.vishwas.main.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vishwas.main.DAO.AccountCheckDAO;
import org.vishwas.main.DAO.UserCreateDAO;
import org.vishwas.main.model.Account;
import org.vishwas.main.model.User;

@Service
public class PersistUser {
	
	@Autowired
	private AccountCheckDAO accountCheckDao;
	@Autowired
	private UserCreateDAO userCreateDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistUser.class);
	
	public long generateRandom(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	   return Long.parseLong(new String(digits));
	}
	public void persistUser(User user) {
		userCreateDao.save(user);
		Account account = new Account();
		long accountNumber=generateRandom(10);
		LOGGER.debug("Your generated Account number is: "+accountNumber);
		account.setAccountNumber(accountNumber);
		account.setOutStanding(2000);
		account.setUser(user);
		accountCheckDao.save(account);
	}
}
