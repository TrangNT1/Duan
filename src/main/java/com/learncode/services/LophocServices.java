package com.learncode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learncode.models.Lophoc;
import com.learncode.models.User;


@Service
public interface LophocServices {

	void deleteAll();

	void deleteAll(List<Lophoc> entities);

	void delete(Lophoc entity);

	void deleteById(Integer id);

	long count();

	List<Lophoc> findAllById(List<Integer> ids);

	Iterable<Lophoc> findAll();

	boolean existsById(Integer id);

	Optional<Lophoc> findById(Integer id);

	List<Lophoc> saveAll(List<Lophoc>  entities);

	Lophoc save(Lophoc entity);

	boolean checkLogin(String username, String password);

	Optional<User> findByIdUser(String id);



}
