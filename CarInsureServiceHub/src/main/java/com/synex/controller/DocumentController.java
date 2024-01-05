package com.synex.controller;

import com.synex.domain.Document;
import com.synex.service.DocumentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins="http://localhost:8282")
@RequestMapping("/documents")
public class DocumentController {
	
	@Autowired
    private final DocumentService documentService;

    
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    /*@GetMapping("/upload")
    public String uploadForm() {
        return "upload-form"; // Create a JSP file for the upload form.
    }*/

   /* @PostMapping("/upload")
    public String uploadDocument(@RequestParam("file") MultipartFile[] files) {
        for (MultipartFile file: files) {
        	documentService.saveDocument(file);
        }
    	
        return "File Uploaded"; // Redirect to a success page.
    }*/
    
    @PostMapping("/upload")
    public ResponseEntity<Document> uploadDocument(@RequestParam("file") MultipartFile[] files) {
        try {
            List<Document> uploadedDocuments = new ArrayList<>();

            for (MultipartFile file : files) {
                Document document = documentService.saveDocument(file);
                uploadedDocuments.add(document);
            }

            if (uploadedDocuments.isEmpty()) {
                // Handle the case when no documents are uploaded
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            // Assuming you want to return the first uploaded document as a response
            Document firstDocument = uploadedDocuments.get(0);

            // You can return the document entity or its ID as needed
            return ResponseEntity.ok(firstDocument);
        } catch (Exception e) {
            // Handle the exception, e.g., by returning an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    /*@PostMapping("/upload")
    public ResponseEntity<List<Document>> uploadDocuments(@RequestParam("file") MultipartFile[] files) {
        try {
            List<Document> uploadedDocuments = new ArrayList<>();

            for (MultipartFile file : files) {
                Document document = documentService.saveDocument(file);
                uploadedDocuments.add(document);
            }

            if (uploadedDocuments.isEmpty()) {
                // Handle the case when no documents are uploaded
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(uploadedDocuments);
            }

            return ResponseEntity.ok(uploadedDocuments);
        } catch (Exception e) {
            // Handle the exception, e.g., by returning an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }*/


    
    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getDocumentImage(@PathVariable Long id) {
        Document document = documentService.findDocumentById(id);
        if (document != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Set the appropriate content type (assuming JPEG format)

            // Retrieve the image data from the Document entity
            byte[] imageData = document.getDriverLicense();

            return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
