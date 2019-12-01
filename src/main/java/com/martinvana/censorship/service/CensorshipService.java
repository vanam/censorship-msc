package com.martinvana.censorship.service;

import com.martinvana.censorship.model.Document;
import com.martinvana.censorship.model.DocumentIssues;

/**
 * Censorship business logic.
 */
public interface CensorshipService {

    /**
     * @param document A document to scan for inappropriate words.
     * @return Issues which were found in the document.
     */
    DocumentIssues scan(Document document);
}
