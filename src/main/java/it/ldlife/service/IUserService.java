package it.ldlife.service;

import it.ldlife.common.ServiceResponse;
import it.ldlife.pojo.User;

/**
 * Created by xubinhui on 17-5-16.
 */
public interface IUserService {

    ServiceResponse<User> login(String username, String password);

    ServiceResponse<String> register(User user);

}
