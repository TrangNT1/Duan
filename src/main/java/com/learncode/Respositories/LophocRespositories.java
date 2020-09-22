package com.learncode.Respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learncode.models.Lophoc;

@Repository
public interface LophocRespositories extends CrudRepository<Lophoc, Integer> {

}
