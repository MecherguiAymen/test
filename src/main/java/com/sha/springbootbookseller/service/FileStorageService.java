package com.sha.springbootbookseller.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sha.springbootbookseller.model.FileDb;
import com.sha.springbootbookseller.repository.FileRepository;

@Service
public class FileStorageService implements IFileService {

	
	
	  @Autowired
	  private FileRepository fileDBRepository;

	  @Override
	  public FileDb store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileDb FileDB = new FileDb(fileName, file.getContentType(), file.getBytes());

	    return fileDBRepository.save(FileDB);
	  }


}
