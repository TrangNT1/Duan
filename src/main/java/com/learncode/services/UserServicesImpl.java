package com.learncode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learncode.Respositories.UserRespositories;
import com.learncode.models.User;

@Service
public class UserServicesImpl implements UserServices{
	@Autowired
	UserRespositories userRespositories;

	@Override
	public User save(User entity) {
		return userRespositories.save(entity);
	}

	@Override
	public List<User> saveAll(List<User> entities) {
		return (List<User>) userRespositories.saveAll(entities);
	}

	@Override
	public Optional<User> findById(String id) {
		return userRespositories.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return userRespositories.existsById(id);
	}

	@Override
	public Iterable<User> findAll() {
		return userRespositories.findAll();
	}

	@Override
	public List<User> findAllById(List<String> ids) {
		return (List<User>)userRespositories.findAllById(ids);
	}

	@Override
	public long count() {
		return userRespositories.count();
	}

	@Override
	public void deleteById(String id) {
		userRespositories.deleteById(id);
	}

	@Override
	public void delete(User entity) {
		userRespositories.delete(entity);
	}

	@Override
	public void deleteAll(List<User> entities) {
		userRespositories.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userRespositories.deleteAll();
	}
	
	@Override
	public User findByUsername(String username) {
		return userRespositories.findByUsername(username);
	}
	@Override
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser= findById(username);
		if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean checkExits(User user) {

		User  u = findByUsername(user.getUsername());
		if (u == null) {
			return false;
		}else {
			if (u.getUsername()== user.getUsername()) {
				return false;
			}
		}
		return true;
	}
}
