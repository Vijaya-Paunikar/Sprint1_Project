
//DocumentRepository.java
package com.example.shared;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
 // Add custom queries if needed
}
