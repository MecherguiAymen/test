package com.sha.springbootbookseller.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.sha.springbootbookseller.model.FileDb;


public interface IFileService {
	public FileDb store(MultipartFile file) throws IOException;

}
