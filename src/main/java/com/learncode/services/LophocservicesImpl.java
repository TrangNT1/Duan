package com.learncode.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learncode.Respositories.LophocRespositories;
import com.learncode.Respositories.UserRespositories;
import com.learncode.models.Lophoc;
import com.learncode.models.User;



@Service
public class LophocservicesImpl implements LophocServices{
	@Autowired
	LophocRespositories lophocRespositories;
	
	
	@Override
	public Lophoc save(Lophoc entity) {
		return lophocRespositories.save(entity);
	}
	@Autowired
	UserRespositories userRespositories;

	@Override
	public Optional<User> findByIdUser(String id) {
		return userRespositories.findById(id);
	}


	@Override
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser= findByIdUser(username);
		if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	@Override
	public List<Lophoc> saveAll(List<Lophoc>  entities) {
		return (List<Lophoc>)lophocRespositories.saveAll(entities);
	}

	@Override
	public Optional<Lophoc> findById(Integer id) {
		return lophocRespositories.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return lophocRespositories.existsById(id);
	}

	@Override
	public Iterable<Lophoc> findAll() {
		return lophocRespositories.findAll();
	}

	@Override
	public List<Lophoc>  findAllById(List<Integer> ids) {
		return (List<Lophoc>)lophocRespositories.findAllById(ids);
	}

	@Override
	public long count() {
		return lophocRespositories.count();
	}

	@Override
	public void deleteById(Integer id) {
		lophocRespositories.deleteById(id);
	}

	@Override
	public void delete(Lophoc entity) {
		lophocRespositories.delete(entity);
	}

	@Override
	public void deleteAll(List<Lophoc> entities) {
		lophocRespositories.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		lophocRespositories.deleteAll();
	}
	
	


	
	

}
