// Database configuration class
package org.tiger.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DatabaseConfig {
    @Inject
    EntityManager entityManager;

    @Transactional
    public void setup() {
        entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS submissions (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255), message TEXT)").executeUpdate();
    }
}
