package org.vishwas.main.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vishwas.main.model.Account;

@Repository
public interface AccountCheckDAO extends CrudRepository<Account,Integer>{
	
}
