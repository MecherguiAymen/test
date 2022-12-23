package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.FileDb;
import com.sha.springbootbookseller.model.Role;
import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserService implements IUserService
{
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user,MultipartFile file) throws IOException
    {
    	if(!Objects.isNull(file)) {
    		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	 	    FileDb FileDB = new FileDb(fileName, file.getContentType(), file.getBytes());
    	 	    user.setFiledb(FileDB);
    	}
        try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional //TransactionalRequired when executing an update/delete query.
    public void makeAdmin(String username)
    {
        userRepository.updateUserRole(username, Role.ADMIN);
    }


}
