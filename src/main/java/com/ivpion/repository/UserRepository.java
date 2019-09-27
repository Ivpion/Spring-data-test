package com.ivpion.repository;

import com.ivpion.model.entity.user.UserEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntry, Integer> {

    UserEntry findById(int id);

    UserEntry findByLogin(String login);

}
