package com.aryan.dreamshops.service.user;

import com.aryan.dreamshops.dto.UserDto;
import com.aryan.dreamshops.model.User;
import com.aryan.dreamshops.request.CreateUserRequest;
import com.aryan.dreamshops.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();
}
