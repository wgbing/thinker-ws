package com.jyou.thinker.ws;

import com.jyou.thinker.ws.domain.User;
import com.jyou.thinker.ws.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class WsApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        try{
            User u = new User();
//            u.setId(1L);
            u.setCreateTime(new Date());
            u.setUserName("da21");
            u.setPassword("da1");
            List list = userMapper.selectAll();
            System.out.println("size:"+list.size());
//        userMapper.deleteByPrimaryKey(1L);
//        userMapper.updateByPrimaryKey(u);
        userMapper.save(u);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
