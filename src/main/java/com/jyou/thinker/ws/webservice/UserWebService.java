package com.jyou.thinker.ws.webservice;

import com.jyou.thinker.ws.common.param.Query;
import com.jyou.thinker.ws.domain.User;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserWebService {
    User getById(Long id);
    List<User> list();
    int deleteById(Long id);
    int save(String o);
    int update(String s);
}
