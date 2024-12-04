package com.uam.egresados.controller;

import com.uam.egresados.model.Advertisement;

import com.uam.egresados.service.IServiceAdvertisement;
import com.uploadcare.upload.UploadFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

    @Autowired
    private IServiceAdvertisement advertisementService;

    @GetMapping
    public ResponseEntity<List<Advertisement>> getAllAdvertisements() {
        return ResponseEntity.ok(advertisementService.getAllAdvertisements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable String id) {
        Optional<Advertisement> advertisement = advertisementService.getAdvertisementById(id);
        return advertisement.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Advertisement> createAdvertisement(
            @RequestPart("advertisement") Advertisement advertisement,
            @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        Advertisement createdAd = advertisementService.createAdvertisement(advertisement, file);
        return ResponseEntity.ok(createdAd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advertisement> updateAdvertisement(
            @PathVariable String id,
            @RequestPart("advertisement") Advertisement updatedAdvertisement,
            @RequestPart(value = "file", required = false) MultipartFile file) throws IOException, UploadFailureException {
        Advertisement updatedAd = advertisementService.updateAdvertisement(id, updatedAdvertisement, file);
        return ResponseEntity.ok(updatedAd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdvertisement(@PathVariable String id) {
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.ok("Advertisement deleted successfully");
    }
}