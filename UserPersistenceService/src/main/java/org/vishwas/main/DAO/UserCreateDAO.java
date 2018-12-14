package org.vishwas.main.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vishwas.main.model.User;

@Repository
public interface UserCreateDAO extends CrudRepository<User,Integer>{

}
