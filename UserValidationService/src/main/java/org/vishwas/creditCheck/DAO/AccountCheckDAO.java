package org.vishwas.creditCheck.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vishwas.creditCheck.model.Account;

@Repository
public interface AccountCheckDAO extends CrudRepository<Account,Integer>{
	
	@Query(value="select * from account a where a.user_user_id=:user_id",nativeQuery = true)
	public Account findAccountByUserId(@Param("user_id")int userId);

}
