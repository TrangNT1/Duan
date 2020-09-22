package com.learncode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learncode.models.Giaovien;
import com.learncode.models.Lophoc;
import com.learncode.models.Monhoc;
import com.learncode.models.Thoikhoabieu;
import com.learncode.models.User;

@Service
public interface ThoikhoabieuServices {

	void deleteAll();

	void deleteAll(List<Thoikhoabieu> entities);

	void delete(Thoikhoabieu entity);

	void deleteById(Integer id);

	long count();

	List<Thoikhoabieu> findAllById(List<Integer> ids);

	Iterable<Thoikhoabieu> findAll();

	boolean existsById(Integer id);

	Optional<Thoikhoabieu> findById(Integer id);

	List<Thoikhoabieu> saveAll(List<Thoikhoabieu> entities);

	Thoikhoabieu save(Thoikhoabieu entity);

	List<Monhoc> findAllMonhoc();

	List<Lophoc> findAllLophoc();

	List<Giaovien> findAllGiaovien();

	boolean checkLogin(String username, String password);

	Optional<User> findByIdUser(String id);

}
