package com.sha.springbootbookseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sha.springbootbookseller.model.FileDb;


@Repository
public interface FileRepository extends JpaRepository<FileDb, String> {

	//FileDb findByUserId(String id);

}