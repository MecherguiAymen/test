package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.Annance;
import com.sha.springbootbookseller.model.Role;

import java.util.List;

/**
 * @author sa
 * @date 3.07.2021
 * @time 18:09
 */
public interface IAnnanceService
{
    Annance saveAnnance(Annance book);

    void deleteAnnance(Long id);

    List<Annance> findAllAnnanceByAdmin();
     List<Annance> findAllAnnanceByUserAndId(Long userId);

	Object updateAnnanceExpirationStatus(Long annaceId, String isExpired);
}
