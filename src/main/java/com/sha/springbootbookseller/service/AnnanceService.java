package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.Annance;
import com.sha.springbootbookseller.model.Role;
import com.sha.springbootbookseller.repository.IAnnanceRepository;
import com.sha.springbootbookseller.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sa
 * @date 3.07.2021
 * @time 18:10
 */
@Service
public class AnnanceService implements IAnnanceService
{
    private final IAnnanceRepository annanceRepository;
    
    Logger logger = LoggerFactory.getLogger(UserService.class);
    
    private final int DAYS=1;
    final LocalDateTime currentDate = LocalDateTime.now();




    public AnnanceService(IAnnanceRepository bookRepository)
    {
        this.annanceRepository = bookRepository;
    }

    @Override
    public Annance saveBook(Annance book)
    {
    	
        book.setCreateTime(LocalDateTime.now());
        book.setIsExpired("n");
        return annanceRepository.save(book);
    }

    @Override
    public void deleteBook(Long id)
    {
    	annanceRepository.deleteById(id);
    }

    @Override
    public List<Annance> findAllAnnanceByAdmin()
    {
    	
    	String str = "2022-12-31T13:42:11";
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    	LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
    	
         logger.info("curent time is"+currentDate);
    	 List<Annance> list= annanceRepository.findAll().stream()
    			                        .filter(a -> a.getIsExpired().startsWith("n") &&  a.getUser().getRole()==Role.ADMIN)
    			                        .collect(Collectors.toList());
    	            list.stream().forEach(p -> {
    	            	  LocalDateTime creationDate=p.getCreateTime();
    	            	  logger.info("creation time is "+creationDate);
    	            	  if(Utils.hasDateExpired(DAYS,creationDate,dateTime)) {
    	            		  p.setIsExpired("o");
    	            	  }
    	              })
    	              ;
    	return list;
    }

	@Override
	public List<Annance> findAllAnnanceByUserAndId( Long userId) {
		    List<Annance> annances= annanceRepository.findAnnanceByUserId(userId).stream()
		                    .filter(a -> a.getUser().getId().compareTo(userId)==0
		    		                         && a.getIsExpired().startsWith("n") 
		       			                     &&  a.getUser().getRole()==Role.USER)
		                    .collect(Collectors.toList());
		                    annances.stream().forEach(p -> {
		    	            	  LocalDateTime creationDate=p.getCreateTime();
		    	            	  logger.info("creation time is "+creationDate);
		    	            	  if(Utils.hasDateExpired(DAYS,creationDate,currentDate)) {
		    	            		  p.setIsExpired("o");
		    	            	  }
		    	              })
		    	              ;                    
		return annances;
	}
}
