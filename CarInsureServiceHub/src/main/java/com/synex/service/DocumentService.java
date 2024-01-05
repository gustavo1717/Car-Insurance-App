package com.synex.service;

import com.synex.domain.Document;
import com.synex.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {

	@Autowired DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document saveDocument(MultipartFile file) {
        try {
            byte[] fileData = file.getBytes();
            String fileName = file.getOriginalFilename();
            Document document = new Document(fileData, fileName);
            return documentRepository.save(document);
        } catch (IOException e) {
            // Handle the exception appropriately
            return null;
        }
    }
    
    /*public List<Document> saveDocument(MultipartFile[] files) {
        List<Document> savedDocuments = new ArrayList<>();
        
        for (MultipartFile file : files) {
            try {
                byte[] fileData = file.getBytes();
                String fileName = file.getOriginalFilename();
                Document document = new Document(fileData, fileName);
                savedDocuments.add(documentRepository.save(document));
            } catch (IOException e) {
                // Handle the exception appropriately
            }
        }
        
        return savedDocuments;
    }*/

    
    public Document findDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }
}
