package com.guoshouxiang.nest.demo.contract;


import java.util.List;

public interface UserService {
    void create(String userName, String pwd);
    UserDto get(String id);
    List<UserDto> query();
}
