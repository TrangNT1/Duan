package com.learncode.Respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learncode.models.Monhoc;

@Repository
public interface MonhocRespositories extends CrudRepository<Monhoc,Integer>{

}
