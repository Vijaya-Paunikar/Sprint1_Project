// DocumentController.java
package com.example.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private FileService fileService; // Inject FileService

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("description") String description) {
        try {
            documentService.uploadDocument(file, name, description);
            return ResponseEntity.ok("Document uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading document: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable String fileName) throws IOException {
        Path filePath = fileService.getFilePath(fileName);
        byte[] documentBytes = Files.readAllBytes(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileName).build());
        return new ResponseEntity<>(documentBytes, headers, HttpStatus.OK);
    }
}