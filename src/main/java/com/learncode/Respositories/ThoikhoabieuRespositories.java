package com.learncode.Respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learncode.models.Thoikhoabieu;

@Repository
public interface ThoikhoabieuRespositories extends CrudRepository<Thoikhoabieu, Integer> {

}
