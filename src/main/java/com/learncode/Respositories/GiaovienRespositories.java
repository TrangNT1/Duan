package com.learncode.Respositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.learncode.models.Giaovien;

@Repository

public interface GiaovienRespositories extends CrudRepository<Giaovien,Integer >{
	@Query("select s from Giaovien s where s.fullname like %?1%")
	public Page<Giaovien> findGiaovienContainName(String name, Pageable page);

	
}