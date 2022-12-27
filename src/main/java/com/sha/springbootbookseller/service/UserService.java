package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.FileDb;
import com.sha.springbootbookseller.model.Role;
import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.repository.IUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    Logger logger = LoggerFactory.getLogger(UserService.class);


    @Override
    public User saveUser(User user,MultipartFile file) throws IOException
    {
    	logger.info("save user with file if exist");
    	if(!Objects.isNull(file)) {
    		logger.debug("extract file name from MultipartFile object");
    		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    		logger.debug("file name is ",fileName);
    		logger.debug("create FileDb object");
    	 	    FileDb FileDB = new FileDb(fileName, file.getContentType(), file.getBytes());
    	 	logger.debug("filedb is ", FileDB);
    	 	logger.debug("set FileDb in User object");
    	 	    user.setFiledb(FileDB);
    	    logger.info("user with picture saved successfully");

    	}
        try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		} catch (Exception e) {
			//logger.error("cannot set password to user");
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
