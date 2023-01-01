package com.sha.springbootbookseller.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sha.springbootbookseller.model.Annance;

/**
 * @author sa
 * @date 3.07.2021
 * @time 17:55
 */
public interface IAnnanceRepository extends JpaRepository<Annance, Long>
{
	public List<Annance> findAnnanceByUserId(Long userId);
	
	  @Modifying
	  @Transactional
	  @Query(
			  value = "update Annance set isexpired = ?2 where id = ?1 ",
			  nativeQuery = true
			  )
	public int updateAnnanceIsExpiredById(Long annaceId, String isExpired);
}
