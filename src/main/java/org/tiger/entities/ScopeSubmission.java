package org.tiger.entities;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Entity class
@Entity
@Table(name = "submissions")
public class ScopeSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime submissionTime;    

    @NotBlank(message = "Scoping Architect name is required")
    @Size(max = 255)
    private String name;

    @NotBlank(message = "Customer name is required")
    @Size(max = 255)
    private String email;

    @NotBlank(message = "Customer name is required")
    @Size(max = 255)
    private String customerName;

    @NotBlank(message = "Pod is required")
    @Size(max = 255)
    private String pod;

    @NotBlank(message = "Service Now Ticket is required")
    @Size(max = 255)
    private String serviceNowTicket;

    @NotBlank(message = "3 Point Spreadsheet URL is required")
    @Size(max = 1024)
    private String threePointSpreadsheet;

    @Size(max = 1024)
    private String googleDriveLink;

    @Size(max = 255)
    private String journey;

    @Size(max = 255)
    private String platform;

    @Size(max = 255)
    private String containerInfrastructure;

    @Size(max = 255)
    private String management;

    @Size(max = 255)
    private String containerAdoption;

    @Size(max = 255)
    private String applicationDevelopment;

    @PrePersist
    protected void onCreate() {
        submissionTime = OffsetDateTime.now(ZoneOffset.UTC);
    }   

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public OffsetDateTime getSubmissionTime() { return submissionTime; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getPod() { return pod; }
    public void setPod(String pod) { this.pod = pod; }

    public String getServiceNowTicket() { return serviceNowTicket; }
    public void setServiceNowTicket(String serviceNowTicket) { this.serviceNowTicket = serviceNowTicket; }

    public String getThreePointSpreadsheet() { return threePointSpreadsheet; }
    public void setThreePointSpreadsheet(String threePointSpreadsheet) { this.threePointSpreadsheet = threePointSpreadsheet; }

    public String getGoogleDriveLink() { return googleDriveLink; }
    public void setGoogleDriveLink(String googleDriveLink) { this.googleDriveLink = googleDriveLink; }

    public String getJourney() { return journey; }
    public void setJourney(String journey) { this.journey = journey; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getContainerInfrastructure() { return containerInfrastructure; }
    public void setContainerInfrastructure(String containerInfrastructure) { this.containerInfrastructure = containerInfrastructure; }

    public String getManagement() { return management; }
    public void setManagement(String management) { this.management = management; }

    public String getContainerAdoption() { return containerAdoption; }
    public void setContainerAdoption(String containerAdoption) { this.containerAdoption = containerAdoption; }

    public String getApplicationDevelopment() { return applicationDevelopment; }
    public void setApplicationDevelopment(String applicationDevelopment) { this.applicationDevelopment = applicationDevelopment; }
}