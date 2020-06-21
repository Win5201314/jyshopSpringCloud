package com.zsl.address.service;

import entity.Users;

public interface IUserService {

    boolean isExistOpenidAndUserId(String openid, Long userId);
    boolean isExistOpenid(String openid);
    boolean addNewUsers(Users users);
    boolean updateUsernameAndAvatar(String openid, String username, String avatar);
    long selectIdByOpenid(String openid);
}
