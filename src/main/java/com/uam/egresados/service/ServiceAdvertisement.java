package com.uam.egresados.service;

import com.uam.egresados.model.Advertisement;
import com.uam.egresados.model.Advertisement.Placement;
import com.uam.egresados.repository.IAdvertisementRepository;
import com.uploadcare.upload.UploadFailureException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAdvertisement implements IServiceAdvertisement {

    @Autowired
    private IAdvertisementRepository advertisementRepository;

    @Autowired
    private FileUploadService fileUploadService;

    @Override
    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }

    @Override
    public Optional<Advertisement> getAdvertisementById(String id) {
        return advertisementRepository.findById(id);
    }

    @Operation(summary = "Create an advertisement with an optional image or banner",
            description = "Send an advertisement JSON object and optionally attach a file for image or banner formats.")
    @PostMapping
    public Advertisement createAdvertisement(Advertisement advertisement, MultipartFile file) {
        if (advertisement.getFormat() == Advertisement.Format.IMAGE ||
                advertisement.getFormat() == Advertisement.Format.BANNER) {
            // Subir el archivo y establecer la URL
            String mediaUrl = null;
            try {
                mediaUrl = fileUploadService.uploadFile(file);
            } catch (IOException | UploadFailureException e) {
                throw new RuntimeException(e);
            }
            advertisement.setMediaUrl(mediaUrl);
        }
        return advertisementRepository.save(advertisement);
    }

    public Advertisement updateAdvertisement(String id, Advertisement updatedAdvertisement, MultipartFile file) {
        Advertisement existingAd = advertisementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Advertisement not found"));

        existingAd.setContent(updatedAdvertisement.getContent());
        existingAd.setFormat(updatedAdvertisement.getFormat());
        existingAd.setPlacement(updatedAdvertisement.getPlacement());
        existingAd.setStartDate(updatedAdvertisement.getStartDate());
        existingAd.setEndDate(updatedAdvertisement.getEndDate());
        existingAd.setIsVisible(updatedAdvertisement.getIsVisible());

        if (file != null &&
                (updatedAdvertisement.getFormat() == Advertisement.Format.IMAGE ||
                        updatedAdvertisement.getFormat() == Advertisement.Format.BANNER)) {
            // Subir el archivo y actualizar la URL
            String mediaUrl = null;
            try {
                mediaUrl = fileUploadService.uploadFile(file);
            } catch (IOException | UploadFailureException e) {
                throw new RuntimeException(e);
            }
            existingAd.setMediaUrl(mediaUrl);
        }

        return advertisementRepository.save(existingAd);
    }

    @Override
    public void deleteAdvertisement(String id) {
        advertisementRepository.deleteById(id);
    }

    /*
    @Override
    public List<Advertisement> getActiveAdvertisements() {
        LocalDateTime now = LocalDateTime.now();
        return advertisementRepository.findByStartDateBeforeAndEndDateAfter(now, now);
    }
    */

    @Override
    public List<Advertisement> getAdvertisementsByPlacement(Placement placement) {
        return advertisementRepository.findByPlacement(placement);
    }
}