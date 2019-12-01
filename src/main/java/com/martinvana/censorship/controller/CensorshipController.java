package com.martinvana.censorship.controller;

import com.martinvana.censorship.model.Document;
import com.martinvana.censorship.model.DocumentIssues;
import com.martinvana.censorship.service.CensorshipService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API.
 */
@RestController
@RequestMapping("/api/v1")
public class CensorshipController {

    /**
     * Censor business logic.
     */
    private final CensorshipService censorshipService;

    /**
     * @param censorshipService Censor business logic.
     */
    public CensorshipController(CensorshipService censorshipService) {
        this.censorshipService = censorshipService;
    }

    /**
     * @param document A document to scan for inappropriate words.
     * @return Issues which were found in the document.
     */
    @PostMapping("/detect")
    public DocumentIssues getClient(@RequestBody Document document) {
        return censorshipService.scan(document);
    }
}
