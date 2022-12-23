package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.User;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author sa
 * @date 3.07.2021
 * @time 18:03
 */
public interface IUserService
{

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);

	User saveUser(User user,MultipartFile file) throws IOException;
}
