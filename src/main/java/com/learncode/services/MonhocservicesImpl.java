package com.learncode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learncode.Respositories.DiemRespositories;
import com.learncode.Respositories.MonhocRespositories;
import com.learncode.Respositories.UserRespositories;
import com.learncode.models.Diem;
import com.learncode.models.Monhoc;
import com.learncode.models.User;


@Service
public class MonhocservicesImpl implements MonhocServices{
	@Autowired
	MonhocRespositories monhocRespositories;
	
	@Autowired
	DiemRespositories diemRespositories;
	
	
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
	public Monhoc save(Monhoc entity) {
		return monhocRespositories.save(entity);
	}
	
	@Override
	public  List<Diem> findAllDiem() {
		return (List<Diem>)diemRespositories.findAll();
	}
	@Override
	public List<Monhoc> saveAll(List<Monhoc> entities) {
		return (List<Monhoc>)monhocRespositories.saveAll(entities);
	}

	@Override
	public Optional<Monhoc> findById(Integer id) {
		return monhocRespositories.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return monhocRespositories.existsById(id);
	}

	@Override
	public Iterable<Monhoc> findAll() {
		return monhocRespositories.findAll();
	}

	@Override
	public List<Monhoc>  findAllById(List<Integer> ids) {
		return (List<Monhoc>)monhocRespositories.findAllById(ids);
	}

	@Override
	public long count() {
		return monhocRespositories.count();
	}

	@Override
	public void deleteById(Integer id) {
		monhocRespositories.deleteById(id);
	}

	@Override
	public void delete(Monhoc entity) {
		monhocRespositories.delete(entity);
	}

	@Override
	public void deleteAll(List<Monhoc> entities) {
		monhocRespositories.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		monhocRespositories.deleteAll();
	}
	
	
}
