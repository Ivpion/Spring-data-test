package com.ivpion.service;

import com.ivpion.config.AppConfig;
import com.ivpion.model.entity.user.UserEntry;
import com.ivpion.model.enums.SystemType;
import com.ivpion.model.enums.UserStatus;
import com.ivpion.utils.LazyDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class IUserServiceImplTest {

    @Autowired
    @Qualifier("IUserServiceImpl")
    private IUserService iUserService;

    @Before
    @Rollback(false)
    public void setUp(){
        UserEntry user = new UserEntry(UUID.randomUUID().toString(), "Ivan", "12345", UserStatus.AVAILEBLE, LazyDate.getUnixTimestamp(), UUID.randomUUID().toString(), null, SystemType.WEB, null);
        iUserService.save(user);
    }

    @Test
    public void save() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void findByLogin() {
        System.out.println(iUserService.findById(1));
    }

    @Test
    public void findById() {
        System.out.println(iUserService.findByLogin("Ivan"));
    }
}