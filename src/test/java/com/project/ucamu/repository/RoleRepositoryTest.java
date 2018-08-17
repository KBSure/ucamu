package com.project.ucamu.repository;

import com.project.ucamu.domain.Role;
import com.project.ucamu.domain.enums.RoleName;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void findTest(){
        Role roleByRoleName = roleRepository.findRoleByRoleName(RoleName.USER);
        System.out.println(roleByRoleName.getRoleName());
        assertEquals(roleByRoleName.getRoleName(), RoleName.USER);
//        assertNotNull(roleByRoleName);
    }
}
