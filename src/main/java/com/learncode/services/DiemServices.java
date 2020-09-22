package com.learncode.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learncode.models.Diem;
import com.learncode.models.Giaovien;
import com.learncode.models.Monhoc;
import com.learncode.models.Sinhvien;
import com.learncode.models.User;


@Service
public interface DiemServices {

	void deleteAll();

	void deleteAll(List<Diem> entities);

	void delete(Diem entity);

	void deleteById(Integer id);

	long count();

	List<Diem> findAllById(List<Integer> ids);

	Iterable<Diem> findAll();

	boolean existsById(Integer id);

	Optional<Diem> findById(Integer id);

	List<Diem> saveAll(List<Diem> entities);

	Diem save(Diem entity);

	List<Giaovien> findAllGiaovien();

	List<Sinhvien> findAllSinhvien();

	List<Monhoc> findAllMonhoc();

	boolean checkLogin(String username, String password);

	Optional<User> findByIdUser(String id);
	
}
