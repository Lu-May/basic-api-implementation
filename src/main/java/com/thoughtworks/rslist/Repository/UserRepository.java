package com.thoughtworks.rslist.Repository;

import com.thoughtworks.rslist.Po.UserPo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserPo, Integer> {
    @Override
    List<UserPo> findAll();
}
