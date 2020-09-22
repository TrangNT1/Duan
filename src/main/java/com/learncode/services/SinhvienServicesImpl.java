package com.learncode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learncode.Respositories.LophocRespositories;
import com.learncode.Respositories.SinhvienRespositories;
import com.learncode.Respositories.UserRespositories;
import com.learncode.models.Lophoc;
import com.learncode.models.Sinhvien;
import com.learncode.models.User;

@Service
public class SinhvienServicesImpl implements SinhvienServices{
	@Autowired
	SinhvienRespositories sinhvienRespositories;
	
	@Autowired
	LophocRespositories lophocRespositories;

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
	public  List<Lophoc> findAllLophoc() {
		return (List<Lophoc>)lophocRespositories.findAll();
	}

	@Override
	public Sinhvien save(Sinhvien entity) {
		return sinhvienRespositories.save(entity);
	}

	@Override
	public List<Sinhvien> saveAll(List<Sinhvien> entities) {
		return (List<Sinhvien>)sinhvienRespositories.saveAll(entities);
	}

	@Override
	public Optional<Sinhvien> findById(Integer id) {
		return sinhvienRespositories.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return sinhvienRespositories.existsById(id);
	}

	@Override
	public Iterable<Sinhvien> findAll() {
		return sinhvienRespositories.findAll();
	}

	@Override
	public List<Sinhvien> findAllById(List<Integer> ids) {
		return (List<Sinhvien>)sinhvienRespositories.findAllById(ids);
	}

	@Override
	public long count() {
		return sinhvienRespositories.count();
	}

	@Override
	public void deleteById(Integer id) {
		sinhvienRespositories.deleteById(id);
	}

	@Override
	public void delete(Sinhvien entity) {
		sinhvienRespositories.delete(entity);
	}

	@Override
	public void deleteAll(List<Sinhvien> entities) {
		sinhvienRespositories.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		sinhvienRespositories.deleteAll();
	}
	
	
	
	
}
