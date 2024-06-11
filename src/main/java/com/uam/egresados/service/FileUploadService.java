package com.uam.egresados.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class FileUploadService {
    private final WebClient webClient;

    @Value("${uploadcare.public_key}")
    private String publicKey;

    @Value("${uploadcare.store}")
    private String store;

    public FileUploadService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://upload.uploadcare.com").build();
    }

    public Mono<String> uploadFile(MultipartFile file) {

            MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();
            bodyBuilder.part("UPLOADCARE_PUB_KEY", publicKey);
            bodyBuilder.part("UPLOADCARE_STORE", store);

            try {
                bodyBuilder.part(Objects.requireNonNull(file.getOriginalFilename()), new ByteArrayResource(file.getBytes()))
                        .header("Content-Disposition", "form-data; name=\"file\"; filename=\"" + file.getOriginalFilename() + "\"")
                        .contentType(MediaType.APPLICATION_OCTET_STREAM);
            }catch(Exception ignored) {

            }


            return this.webClient.post()
                    .uri("/base/")
                    .contentType(MediaType.MULTIPART_FORM_DATA)
                    .body(BodyInserters.fromMultipartData(bodyBuilder.build()))
                    .retrieve()
                    .bodyToMono(String.class)
                    .map(response -> {
                        JSONObject jsonResponse = new JSONObject(response);
                        String fileUUID = jsonResponse.getString(file.getOriginalFilename());
                        return "https://ucarecdn.com/" + fileUUID + "/";
                    });
        }
    }
