package com.learncode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learncode.Respositories.GiaovienRespositories;
import com.learncode.Respositories.LophocRespositories;
import com.learncode.Respositories.MonhocRespositories;
import com.learncode.Respositories.ThoikhoabieuRespositories;
import com.learncode.Respositories.UserRespositories;
import com.learncode.models.Giaovien;
import com.learncode.models.Lophoc;
import com.learncode.models.Monhoc;

import com.learncode.models.Thoikhoabieu;
import com.learncode.models.User;

@Service
public class ThoikhoabieuservicesImpl implements ThoikhoabieuServices{
	@Autowired
	ThoikhoabieuRespositories thoikhoabieuRespositories;
	
	@Autowired
	LophocRespositories lophocRespositories;
	
	@Autowired
	GiaovienRespositories giaovienRespositories;
	
	@Autowired
	MonhocRespositories monhocRespositories;
	
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
	public  List<Giaovien> findAllGiaovien() {
		return (List<Giaovien>)giaovienRespositories.findAll();
	}
	
	@Override
	public  List<Lophoc> findAllLophoc() {
		return (List<Lophoc>)lophocRespositories.findAll();
	}
	@Override
	public  List<Monhoc> findAllMonhoc() {
		return (List<Monhoc>)monhocRespositories.findAll();
	}
	
	@Override
	public Thoikhoabieu save(Thoikhoabieu entity) {
		return thoikhoabieuRespositories.save(entity);
	}

	@Override
	public List<Thoikhoabieu> saveAll(List<Thoikhoabieu> entities) {
		return (List<Thoikhoabieu>)thoikhoabieuRespositories.saveAll(entities);
	}

	@Override
	public Optional<Thoikhoabieu> findById(Integer id) {
		return thoikhoabieuRespositories.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return thoikhoabieuRespositories.existsById(id);
	}

	@Override
	public Iterable<Thoikhoabieu> findAll() {
		return thoikhoabieuRespositories.findAll();
	}

	@Override
	public List<Thoikhoabieu> findAllById(List<Integer> ids) {
		return (List<Thoikhoabieu>)thoikhoabieuRespositories.findAllById(ids);
	}

	@Override
	public long count() {
		return thoikhoabieuRespositories.count();
	}

	@Override
	public void deleteById(Integer id) {
		thoikhoabieuRespositories.deleteById(id);
	}

	@Override
	public void delete(Thoikhoabieu entity) {
		thoikhoabieuRespositories.delete(entity);
	}

	@Override
	public void deleteAll(List<Thoikhoabieu> entities) {
		thoikhoabieuRespositories.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		thoikhoabieuRespositories.deleteAll();
	}
	
	
}
