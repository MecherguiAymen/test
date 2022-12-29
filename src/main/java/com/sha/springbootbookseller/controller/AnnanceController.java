package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.model.Annance;
import com.sha.springbootbookseller.model.Role;
import com.sha.springbootbookseller.service.IAnnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author sa
 * @date 4.07.2021
 * @time 18:15
 */
@RestController
@RequestMapping("api/book")//pre-path
public class AnnanceController
{
    @Autowired
    private IAnnanceService annanceService;

    @PostMapping //api/book
    public ResponseEntity<?> saveBook(@RequestBody Annance book)
    {
        return new ResponseEntity<>(annanceService.saveBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("{bookId}") //api/book/{bookId}
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId)
    {
    	annanceService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{role}")
    public ResponseEntity<?> getAllAnnanceForAdmin(@PathVariable Role role)
    {
        return new ResponseEntity<>(annanceService.findAllAnnanceByAdmin(role), HttpStatus.OK);
    }
    @GetMapping("{role}/{userId}")
    public ResponseEntity<?> getAllAnnanceForAdmin(@PathVariable Role role,@PathVariable Long userId)
    {
        return new ResponseEntity<>(annanceService.findAllAnnanceByUserAndId(role,userId), HttpStatus.OK);
    }
}
