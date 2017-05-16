package it.ldlife.service.impl;

import it.ldlife.common.ServiceResponse;
import it.ldlife.dao.UserMapper;
import it.ldlife.pojo.User;
import it.ldlife.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xubinhui on 17-5-16.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ServiceResponse<User> login(String username, String password) {
        //判断用户名是否存在
        int resultCount = userMapper.checkUserName(username);
        if(resultCount == 0){
            return ServiceResponse.createByErrorMessage("用户名不存在");
        }

        //// TODO: 17-5-16 密码md5

        User user = userMapper.selectLogin(username,password);
        if (user == null){
            return ServiceResponse.createByErrorMessage("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);
        return ServiceResponse.createBySuccess("登陆成功",user);
    }

    @Override
    public ServiceResponse<String> register(User user) {


        return null;
    }


}
