package it.ldlife.controller.portal;

import it.ldlife.common.Const;
import it.ldlife.common.ServiceResponse;
import it.ldlife.pojo.User;
import it.ldlife.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by xubinhui on 17-5-16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ServiceResponse<User> login(String username, String password, HttpSession session){
        ServiceResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public ServiceResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServiceResponse.createBySuccess();
    }

    public ServiceResponse<String> register(User user){
        ServiceResponse<String> response = iUserService.register(user);
        return null;
    }


}
