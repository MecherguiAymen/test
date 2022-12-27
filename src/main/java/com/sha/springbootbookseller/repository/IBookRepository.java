package com.sha.springbootbookseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.springbootbookseller.model.Annance;

/**
 * @author sa
 * @date 3.07.2021
 * @time 17:55
 */
public interface IBookRepository extends JpaRepository<Annance, Long>
{
}
