package com.learncode.Respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learncode.models.Sinhvien;

@Repository

public interface SinhvienRespositories extends CrudRepository<Sinhvien, Integer>{

}
