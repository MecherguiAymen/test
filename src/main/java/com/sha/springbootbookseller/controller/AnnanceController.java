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

    @GetMapping("/annance/admin")
    public ResponseEntity<?> getAllAnnanceForAdmin()
    {
        return new ResponseEntity<>(annanceService.findAllAnnanceByAdmin(), HttpStatus.OK);
    }
    @GetMapping("annance/user/{userId}")
    public ResponseEntity<?> getAllAnnanceForAdmin(@PathVariable Long userId)
    {
        return new ResponseEntity<>(annanceService.findAllAnnanceByUserAndId(userId), HttpStatus.OK);
    }
}
