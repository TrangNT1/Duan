package com.learncode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learncode.models.Diem;
import com.learncode.models.Monhoc;
import com.learncode.models.User;


@Service
public interface MonhocServices {

	void deleteAll();

	void deleteAll(List<Monhoc> entities);

	void delete(Monhoc entity);

	void deleteById(Integer id);

	long count();

	List<Monhoc> findAllById(List<Integer> ids);

	Iterable<Monhoc> findAll();

	boolean existsById(Integer id);

	Optional<Monhoc> findById(Integer id);

	List<Monhoc> saveAll(List<Monhoc> entities);

	Monhoc save(Monhoc entity);

	List<Diem> findAllDiem();

	boolean checkLogin(String username, String password);

	Optional<User> findByIdUser(String id);


	
}
