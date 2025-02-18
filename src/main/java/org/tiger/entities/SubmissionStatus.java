package org.tiger.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.tiger.variables.Status;

// Entity class
@Entity
@Table(name = "statues")
public class SubmissionStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Submission ID is required")
    @Size(max = 255)
    private String submissionID;

    @NotBlank(message = "Status of the submission is required")
    @Size(max = 255)
    private Status status;

    private String updatedBy; // Store user who changed the status

    private LocalDateTime updatedAt; // Store status change time

    public SubmissionStatus() {}

    public SubmissionStatus(String submissionID, Status status, String updatedBy) {
        this.submissionID = submissionID;
        this.status = status;
        this.updatedBy = updatedBy;
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubmissionID() { return submissionID; }
    public void setSubmissionID(String submissionID) { this.submissionID = submissionID; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }
}