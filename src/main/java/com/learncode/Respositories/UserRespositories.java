package com.learncode.Respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.learncode.models.User;

@Repository
public interface UserRespositories extends CrudRepository<User,String> {
	User findByUsername(String username);
}
