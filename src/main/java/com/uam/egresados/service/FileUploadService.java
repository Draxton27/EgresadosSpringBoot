package com.uam.egresados.service;

import com.uploadcare.api.Client;
import com.uploadcare.upload.FileUploader;
import com.uploadcare.upload.UploadFailureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class FileUploadService {

    @Value("${uploadcare.public_key}")
    private String publicKey;

    @Value("${uploadcare.secret_key}")
    private String secretKey;
    public static File createFileOnDisk(byte[] byteArray, String name) throws IOException {
        File output = File.createTempFile(name,null);
        Files.write(output.toPath(),byteArray);
        return output;
    }
    public String uploadFile(MultipartFile file) throws IOException, UploadFailureException {
        var file_bytes = file.getBytes();
        var localFile = createFileOnDisk(file_bytes, file.getOriginalFilename());
        Client client = new Client(publicKey,secretKey);
        var uploader = new FileUploader(client, localFile);
        var uploadedFile = uploader.upload();
        var fileUUID = uploadedFile.getFileId();
        localFile.deleteOnExit();
        return "https://ucarecdn.com/" + fileUUID + "/";
    }
}
