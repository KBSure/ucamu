package com.project.ucamu.repository;

import com.project.ucamu.domain.Role;
import com.project.ucamu.domain.User;
import com.project.ucamu.domain.UserSituation;
import com.project.ucamu.domain.enums.RoleName;
import com.project.ucamu.domain.enums.SituationState;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserSituationRepository userSituationRepository;

    @Autowired
    UserRepository userRepository;


    @Test
    public void userSaveTest(){
        User user = new User();
//        BeanUtils.copyProperties(userFormDto, user);
        user.setEmail("a");
        user.setName("b");
        user.setNickname("c");
        user.setPassword("p");
        user.setPhone("0");

        Role role = roleRepository.findRoleByRoleName(RoleName.USER);
        UserSituation situation = userSituationRepository.findUserSituationByState(SituationState.NORMAL);
        user.addRole(role);
        user.setUserSituation(situation);

        User save = userRepository.save(user);
        assertNotNull(save);

        System.out.println(save.getEmail());
        System.out.println(save.getUserSituation().getState());
    }
}
