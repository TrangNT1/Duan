package com.learncode.Respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learncode.models.Diem;

@Repository
public interface DiemRespositories extends CrudRepository<Diem, Integer>{

}
