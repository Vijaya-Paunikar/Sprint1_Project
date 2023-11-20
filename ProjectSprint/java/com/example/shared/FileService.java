// FileService.java
package com.example.shared;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    @Value("${upload.directory}")
    private String uploadDirectory;

    public String saveFile(MultipartFile file) throws IOException {
        // Get the file bytes
        byte[] bytes = file.getBytes();

        // Create the directory if it doesn't exist
        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Save the file
        String filePath = directory.getAbsolutePath() + File.separator + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        return filePath;
    }

    public Path getFilePath(String fileName) {
        return Paths.get(uploadDirectory).resolve(fileName).normalize();
    }
}