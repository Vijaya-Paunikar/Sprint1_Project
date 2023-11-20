// DocumentService.java
package com.example.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private FileService fileService;

    public void uploadDocument(MultipartFile file, String name, String description) throws IOException {
        // Save file to storage
        String filePath = fileService.saveFile(file);

        // Create Document entity
        Document document = new Document();
        document.setName(name);
        document.setDescription(description);
        document.setFilePath(filePath);

        // Save document to database
        documentRepository.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

}