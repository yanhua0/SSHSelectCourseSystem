package org.select.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.select.entity.User;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
//    private static Logger logger = Logger.getLogger(UserDaoTest.class);
private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());
    @Test
    public void findByUsernameAndPassword() {
        User user=new User();
        user.setUsername("1");
        user.setPassword("1");
        User user2=userDao.findByUsernameAndPassword(user);
        System.out.println(user2+"jjjjjjjjjjj");
        logger.info("user{}"+user2);
    }

    @Test
    public void save() {
        User user=new User();
        user.setUsername("52");
        user.setPassword("12");
        user.setState(1);
        user.setName("dddd");
        userDao.save(user);
        }

    @Test
    public void saveList() {
        User user=new User();
        user.setUsername("311");
        user.setPassword("12");
        user.setState(1);
        user.setName("dddd");
        List<User> list=new ArrayList<User>();
        list.add(user);
        User user1=new User();
        user1.setUsername("1511");
        user1.setPassword("12");
        user1.setState(1);
        user1.setName("dddd");
        list.add(user1);
        userDao.saveList(list);
    }

    @Test
    public void deleteList() {
        User user=new User();
        user.setUsername("311");
        user.setPassword("12");
        user.setState(1);
        user.setName("dddd");
        List<User> list=new ArrayList<User>();
        list.add(user);
        User user1=new User();
        user1.setUsername("1511");
        user1.setPassword("12");
        user1.setState(1);
        user1.setName("dddd");
        list.add(user1);
        userDao.deleteList(list);
    }

    @Test
    public void updateList() {
        User user=new User();
        user.setUsername("1");
        user.setPassword("1");
        List<User> list=new ArrayList<User>();
        User user1=userDao.findByUsernameAndPassword(user);
        user1.setName("邹桔林");
        list.add(user1);
        User user2=new User();
        user2.setUsername("2");
        user2.setPassword("1");
        User user3=userDao.findByUsernameAndPassword(user2);
        user3.setName("123");
        list.add(user3);
        userDao.updateList(list);
    }
    @Test
    public void hashmap() {
        User user=new User();
        user.setUsername("1");
        user.setPassword("1");
        User user1=userDao.findByUsernameAndPassword(user);
        Map<String, String> map = new HashMap<String, String>();
        map.put("aa", "@sohu.com");

        map.put("bb","@163.com");

        map.put("cc", "@sina.com");

        System.out.println("普通的遍历方法，通过Map.keySet遍历key和value");//普通使用，二次取值

        for (String key : map.keySet()) {

            System.out.println("key= "+key+" and value= "+map.get(key));

        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
           System.out.println(entry.getKey());
           System.out.println( entry.getValue());
        }

    }

}