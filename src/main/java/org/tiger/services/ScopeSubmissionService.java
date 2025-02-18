// Service class
package org.tiger.services;

import org.tiger.entities.ScopeSubmission;
import org.tiger.entities.SubmissionStatus;
import org.tiger.variables.Status;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class ScopeSubmissionService {
    @Inject
    EntityManager entityManager;

    public void submitForm(ScopeSubmission submission) {
        entityManager.persist(submission);
        entityManager.persist(new SubmissionStatus(submission.getId().toString(), Status.SUBMITTED, submission.getName()));
    }

    public List<ScopeSubmission> getAllSubmissions() {
        return entityManager.createQuery("SELECT f FROM ScopeSubmission f", ScopeSubmission.class).getResultList();
    }

    public List<ScopeSubmission> getSubmissionsByEmail(String email) {
        TypedQuery<ScopeSubmission> query = entityManager.createQuery("SELECT f FROM ScopeSubmission f WHERE f.email = :email", ScopeSubmission.class);
        query.setParameter("email", email);
        return query.getResultList();
    }
}