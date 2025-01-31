// Service class
package org.tiger.services;

import org.tiger.entities.ScopeSubmission;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ScopeSubmissionService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public void submitForm(ScopeSubmission submission) {
        entityManager.persist(submission);
    }

    public List<ScopeSubmission> getAllSubmissions() {
        return entityManager.createQuery("SELECT f FROM ScopeSubmission f", ScopeSubmission.class).getResultList();
    }
}