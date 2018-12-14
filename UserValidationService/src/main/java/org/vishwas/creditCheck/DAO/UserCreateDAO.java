package org.vishwas.creditCheck.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vishwas.creditCheck.model.User;

@Repository
public interface UserCreateDAO extends CrudRepository<User,Integer>{

	@Query("from USER where mailId =:mailId")
	public User findByEmail(@Param("mailId") String mailId);	
}
