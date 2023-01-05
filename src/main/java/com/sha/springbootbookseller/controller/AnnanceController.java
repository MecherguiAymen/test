package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.exceptions.AnnanceNotFoundException;
import com.sha.springbootbookseller.model.Annance;
import com.sha.springbootbookseller.model.Role;
import com.sha.springbootbookseller.service.IAnnanceService;
import com.sha.springbootbookseller.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("api/annance")//pre-path
public class AnnanceController
{
	
    @Autowired
    private IAnnanceService annanceService;
    
    Logger logger = LoggerFactory.getLogger(UserService.class);


    @PostMapping //api/book
    public ResponseEntity<?> saveAnnance(@RequestBody Annance book)
    {
        return new ResponseEntity<>(annanceService.saveAnnance(book), HttpStatus.CREATED);
    }
    
    

    @DeleteMapping("{annanceid}") //api/book/{bookId}
    public ResponseEntity<?> deleteAnnance(@PathVariable Long annanceid)
    {
    	 annanceService.deleteAnnance(annanceid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    @GetMapping("/admin")
    public ResponseEntity<?> getAllAnnanceForAdmin()
    {
        return new ResponseEntity<>(annanceService.findAllAnnanceByAdmin(), HttpStatus.OK);
    }
    
    
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllAnnanceForUserById(@PathVariable Long userId) throws AnnanceNotFoundException
    {
        return new ResponseEntity<>(annanceService.findAllAnnanceByUserAndId(userId), HttpStatus.OK);
    }
    
    
    
    @PatchMapping("update/isexpired/{annanceId}")
        public ResponseEntity<?> updateIsExpired(@PathVariable Long annanceId,@RequestParam String isExpired)
    {    
           return new ResponseEntity<>(annanceService.updateAnnanceExpirationStatus(annanceId,isExpired),HttpStatus.OK);
    }
    
    @GetMapping("exposefor/user/{userId}")
    public ResponseEntity<?> getAllAnnanceExposeForUser(@PathVariable Long userId) throws AnnanceNotFoundException{
    	return new ResponseEntity<>(annanceService.getAllAnnanceExposeForUser(userId),HttpStatus.OK);
    }

}
