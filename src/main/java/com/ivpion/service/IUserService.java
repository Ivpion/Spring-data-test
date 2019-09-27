package com.ivpion.service;

import com.ivpion.model.entity.user.UserEntry;
import org.springframework.stereotype.Service;


@Service
public interface IUserService {


    boolean save(UserEntry user);

    boolean deleteById(int userId);

    UserEntry findByLogin(String userLogin);

    UserEntry findById(int userId);


}
