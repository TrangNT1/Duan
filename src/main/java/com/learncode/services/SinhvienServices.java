package com.learncode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learncode.models.Lophoc;
import com.learncode.models.Sinhvien;
import com.learncode.models.User;

@Service
public interface SinhvienServices {

	void deleteAll();

	void deleteAll(List<Sinhvien> entities);

	void delete(Sinhvien entity);

	void deleteById(Integer id);

	long count();

	List<Sinhvien> findAllById(List<Integer> ids);

	Iterable<Sinhvien> findAll();

	boolean existsById(Integer id);

	Optional<Sinhvien> findById(Integer id);

	List<Sinhvien> saveAll(List<Sinhvien> entities);

	Sinhvien save(Sinhvien entity);

	List<Lophoc> findAllLophoc();

	boolean checkLogin(String username, String password);

	Optional<User> findByIdUser(String id);

}
