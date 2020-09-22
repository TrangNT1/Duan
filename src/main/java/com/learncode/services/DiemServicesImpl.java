package com.learncode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learncode.Respositories.DiemRespositories;
import com.learncode.Respositories.GiaovienRespositories;
import com.learncode.Respositories.MonhocRespositories;
import com.learncode.Respositories.SinhvienRespositories;
import com.learncode.Respositories.UserRespositories;
import com.learncode.models.Diem;
import com.learncode.models.Giaovien;
import com.learncode.models.Monhoc;
import com.learncode.models.Sinhvien;
import com.learncode.models.User;

@Service
public class DiemServicesImpl implements DiemServices{
	@Autowired
	DiemRespositories diemRespositories;
	@Autowired
	GiaovienRespositories giaovienRespositories;
	
	@Autowired
	SinhvienRespositories sinhvienRespositories;

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
	public  List<Sinhvien> findAllSinhvien() {
		return (List<Sinhvien>)sinhvienRespositories.findAll();
	}

	@Override
	public  List<Giaovien> findAllGiaovien() {
		return (List<Giaovien>)giaovienRespositories.findAll();
	}
	@Override
	public  List<Monhoc> findAllMonhoc() {
		return (List<Monhoc>)monhocRespositories.findAll();
	}

	@Override
	public Diem save(Diem entity) {
		return diemRespositories.save(entity);
	}

	@Override
	public List<Diem> saveAll(List<Diem> entities) {
		return (List<Diem>)diemRespositories.saveAll(entities);
	}

	@Override
	public Optional<Diem> findById(Integer id) {
		return diemRespositories.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return diemRespositories.existsById(id);
	}

	@Override
	public Iterable<Diem> findAll() {
		return diemRespositories.findAll();
	}

	@Override
	public List<Diem> findAllById(List<Integer> ids) {
		return (List<Diem>)diemRespositories.findAllById(ids);
	}

	@Override
	public long count() {
		return diemRespositories.count();
	}

	@Override
	public void deleteById(Integer id) {
		diemRespositories.deleteById(id);
	}

	@Override
	public void delete(Diem entity) {
		diemRespositories.delete(entity);
	}

	@Override
	public void deleteAll(List<Diem> entities) {
		diemRespositories.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		diemRespositories.deleteAll();
	}
	
	
	
}
