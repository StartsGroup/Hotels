package com.hotel.shiro;

import com.hotel.pojo.Users;
import com.hotel.service.UserService;
import com.hotel.service.impl.UserServiceImpl;
import org.apache.catalina.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component("myRealm")
public class MyRealm extends AuthorizingRealm {
    private UserService userService=new UserServiceImpl();
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       AuthenticationInfo authenticationInfo=null;
       Users user=new Users();
        UsernamePasswordToken upt=(UsernamePasswordToken)token;
        String uname=upt.getUsername();
        char[] upassword=upt.getPassword();
        user.setUname(uname);
        user.setUpassword(upassword.toString());
        Users u=userService.login(user);
        if(u!=null&&user.getUid()!=0){
            authenticationInfo=new SimpleAuthenticationInfo(uname,upassword,getName());
        }
        return authenticationInfo;
    }
}
