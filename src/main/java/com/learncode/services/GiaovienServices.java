package com.learncode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.learncode.models.Giaovien;
import com.learncode.models.Lophoc;
import com.learncode.models.User;

@Service
public interface GiaovienServices {


	void deleteAll();

	void deleteAll(List<Giaovien> entities);

	void delete(Giaovien entity);

	void deleteById(Integer id);

	long count();

	Iterable<Giaovien> findAllById(Iterable<Integer> ids);

	List<Giaovien> findAll();

	boolean existsById(Integer id);
	
	boolean checkLogin(String username, String password);

	Optional<Giaovien> findById(Integer id);

	List<Giaovien> saveAll(List<Giaovien> entities);

	Giaovien save(Giaovien entity);

	Page<Giaovien> findGiaovienContainName(String name, Pageable page);

	List<Lophoc> findAllLophoc();

	Optional<User> findByIdUser(String id);

	








	
}
