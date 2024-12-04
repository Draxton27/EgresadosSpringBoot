package com.uam.egresados.repository;

import com.uam.egresados.model.Advertisement;
import com.uam.egresados.model.Advertisement.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdvertisementRepository extends JpaRepository<Advertisement, String> {
    List<Advertisement> findByPlacement(Placement placement);

    List<Advertisement> findByIsVisibleTrue();
}