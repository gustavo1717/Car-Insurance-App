package com.synex.controller;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.File;
import com.synex.domain.EmailDetails;
import com.synex.domain.Policy;
import com.synex.service.PolicyService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8282")
@RestController
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }
    
    @GetMapping("/byUser/{username}")
    public List<Policy> getPolicyByUser(@PathVariable String username) {
        return policyService.getPolicyByUser(username);
    }

    @PostMapping("/savePolicy")
    public Policy createPolicy(@RequestBody Policy policy) {
    	EmailDetails emailDetails = new EmailDetails();
    	RestTemplate restTemplate = new RestTemplate();
        emailDetails.setRecipient("gustahurtado10@gmail.com");
        emailDetails.setSubject("Confirmation for policy for " + policy.getUser());
        emailDetails.setMsgBody("Thank you " + policy.getInsured().getName() + ", you just requested a policy!\n" +
        "Confirmation details:\n"+ "Policy: " + policy.getStatus() + "\nFrom: " + policy.getStartDate() +  "\n"
        +"To: " + policy.getEndDate() + "\nPrice: " + policy.getPlans().get(0).getBasePrice() + 
        "\nVehicle: " + policy.getVehicle().getMake() + policy.getVehicle().getModel());
        
        createSamplePDF("sample.pdf");

        // Attach the PDF to the email
        FileSystemResource pdfFile = new FileSystemResource(new File("sample.pdf"));
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("file", pdfFile);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(parts, headers);

        // Send the email with PDF attachment
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8383/email/send", emailDetails, String.class);

        return policyService.createPolicy(policy);
    }
    
    private void createSamplePDF(String filePath) {
        String projectPath = "C:/Users/gusta/Documents/workspace-spring-tool-suite-4-4.19.1.RELEASE/CarInsuranceMicroservice";
        String pdfFilePath = projectPath + "/" + filePath;

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
            document.open();

            // Add content to the PDF
            document.add(new Paragraph("Hello, this is a sample PDF document."));
            document.add(new Paragraph("You can add more text or content here."));

        } catch (DocumentException | IOException e) {
            // Handle exceptions if necessary
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
    
    
    @PutMapping("/{id}")
    public Policy updatePolicy(@PathVariable Long id, @RequestBody Policy policy) {
        policy.setId(id);
        return policyService.updatePolicy(id, policy);
    }

    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
    }
    
    
    
}
