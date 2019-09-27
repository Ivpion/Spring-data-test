package com.ivpion.repository;

import com.ivpion.model.entity.user.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfileEntity, Integer> {
}
