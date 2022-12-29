package com.sha.springbootbookseller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.springbootbookseller.model.Annance;

/**
 * @author sa
 * @date 3.07.2021
 * @time 17:55
 */
public interface IAnnanceRepository extends JpaRepository<Annance, Long>
{
	public List<Annance> findAnnanceByUserId(Long userId);
}
