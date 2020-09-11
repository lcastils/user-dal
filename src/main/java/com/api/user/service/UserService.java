package com.api.user.service;

import com.api.user.dto.UserRQ;
import com.api.user.dto.UserRS;

public interface UserService {

    public UserRS creatreUser(final UserRQ objUser);

    public UserRS getUserByEmail(final String email);

    public UserRS updateUser(UserRQ user);

    public UserRS deleteUser(UserRQ user);

}
