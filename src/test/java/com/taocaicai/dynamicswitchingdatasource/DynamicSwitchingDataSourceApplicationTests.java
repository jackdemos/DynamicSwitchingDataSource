package com.taocaicai.dynamicswitchingdatasource;

import com.taocaicai.dynamicswitchingdatasource.dao.UserMapper;
import com.taocaicai.dynamicswitchingdatasource.entity.User;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class DynamicSwitchingDataSourceApplicationTests {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void save() {
    User user = new User();
    user.setUsername("master");
    user.setPassword("master");
    user.setSex(1);
    user.setAge(18);
    Assert.assertEquals(1,userMapper.save(user));
  }

  @Test
  public void update() {
    User user = new User();
    user.setId(8L);
    user.setPassword("newpassword");
    // 返回插入的记录数 ，期望是1条 如果实际不是一条则抛出异常
    Assert.assertEquals(1,userMapper.update(user));
  }

  @Test
  public void selectById() {
    User user = userMapper.selectById(4L);
    System.out.println("id:" + user.getId());
    System.out.println("name:" + user.getUsername());
    System.out.println("password:" + user.getPassword());
  }

  @Test
  public void deleteById() {
    Assert.assertEquals(1,userMapper.deleteById(1L));
  }

  @Test
  public void selectAll() {
    List<User> users= userMapper.selectAll();
    users.forEach(user -> {
      System.out.println("id:" + user.getId());
      System.out.println("name:" + user.getUsername());
      System.out.println("password:" + user.getPassword());
    });
  }
}
