package com.uam.egresados.service;

import com.uam.egresados.model.Advertisement;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IServiceAdvertisement {
    List<Advertisement> getAllAdvertisements();

    Optional<Advertisement> getAdvertisementById(String id);

    Advertisement createAdvertisement(Advertisement advertisement, MultipartFile file);

    Advertisement updateAdvertisement(String id, Advertisement updatedAdvertisement, MultipartFile file);

    void deleteAdvertisement(String id);

    //List<Advertisement> getActiveAdvertisements();

    List<Advertisement> getAdvertisementsByPlacement(Advertisement.Placement placement);
}