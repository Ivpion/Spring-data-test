package com.ivpion.service.impl;

import com.ivpion.model.entity.user.UserEntry;
import com.ivpion.repository.UserProfileRepository;
import com.ivpion.repository.UserRepository;
import com.ivpion.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;
    @Autowired
    @Qualifier("userProfileRepository")
    private UserProfileRepository userProfileRepository;

    public IUserServiceImpl() {
    }

    @Override
    @Transactional
    public boolean save(UserEntry user) {
        UserEntry save = this.userRepository.save(user);
        return save != null;
    }


    @Override
    public boolean deleteById(int userId) {
        this.userRepository.deleteById(userId);
        return true;
    }

    @Override
    public UserEntry findByLogin(String userLogin) {
        return userRepository.findByLogin(userLogin);
    }

    @Override
    public UserEntry findById(int userId) {
        return userRepository.findById(userId);
    }
}
