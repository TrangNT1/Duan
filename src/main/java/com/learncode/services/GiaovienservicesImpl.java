package com.learncode.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.learncode.Respositories.GiaovienRespositories;
import com.learncode.Respositories.LophocRespositories;
import com.learncode.Respositories.UserRespositories;
import com.learncode.models.Giaovien;
import com.learncode.models.Lophoc;
import com.learncode.models.User;


@Service
public class GiaovienservicesImpl implements GiaovienServices{
	
	@Autowired
	UserRespositories userRespositories;
	
	@Autowired
	GiaovienRespositories giaovienRespositories;
	
	@Autowired
	LophocRespositories lophocRespositories;
	
	@Override
	public  List<Lophoc> findAllLophoc() {
		return (List<Lophoc>)lophocRespositories.findAll();
	}
	
	@Override
	public Page<Giaovien> findGiaovienContainName(String name, Pageable page) {
		return giaovienRespositories.findGiaovienContainName(name, page);
	}
	
	@Override
	public Giaovien save(Giaovien entity) {
		return giaovienRespositories.save(entity);
	}
	
	@Override
	public Optional<User> findByIdUser(String id) {
		return userRespositories.findById(id);
	}

	@Override
	public List<Giaovien> saveAll(List<Giaovien> entities) {
		return (List<Giaovien>) giaovienRespositories.saveAll(entities);
	}

	@Override
	public Optional<Giaovien> findById(Integer id) {
		return giaovienRespositories.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return giaovienRespositories.existsById(id);
	}

	@Override
	public List<Giaovien> findAll() {
		return (List<Giaovien>)giaovienRespositories.findAll();
	}

	@Override
	public Iterable<Giaovien> findAllById(Iterable<Integer> ids) {
		return giaovienRespositories.findAllById(ids);
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
	public long count() {
		return giaovienRespositories.count();
	}

	@Override
	public void deleteById(Integer id) {
		giaovienRespositories.deleteById(id);
	}

	@Override
	public void delete(Giaovien entity) {
		giaovienRespositories.delete(entity);
	}

	@Override
	public void deleteAll(List<Giaovien> entities) {
		giaovienRespositories.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		giaovienRespositories.deleteAll();
	}
	


	
	

}
