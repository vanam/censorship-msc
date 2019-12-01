package com.martinvana.censorship.service;

import com.martinvana.censorship.model.Document;
import com.martinvana.censorship.model.DocumentIssues;
import com.martinvana.censorship.model.Issues;
import com.martinvana.stringsearch.StringSearch;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.StringTokenizer;

/**
 * Censorship business logic implementation.
 */
@Service
public class CensorshipServiceImpl implements CensorshipService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CensorshipServiceImpl.class);

    /**
     * Searching tool for censored words.
     */
    private StringSearch censoredWordsSearch = new StringSearch("foo", "bar");

    /**
     * Every minute update a list of censored words.
     */
    @Scheduled(fixedRate = 60 * 1000)
    private void reloadCensoredWords() {
        // TODO use banned-word-list-msc
        censoredWordsSearch = new StringSearch("Winnie-the-Pooh", "Pooh");
        LOGGER.info("Updating a list of censored words.");
    }

    @Override
    public DocumentIssues scan(Document document) {
        DocumentIssues issues = new DocumentIssues();

        // Find issues in heading
        issues.setHeadingIssues(new Issues(censoredWordsSearch.search(document.getHeading())));

        // FInd issues in text
        StringTokenizer st = new StringTokenizer(document.getText(), System.lineSeparator());
        int i = 0;
        while (st.hasMoreTokens()) {
            issues.setTextIssues(i++, new Issues(censoredWordsSearch.search(st.nextToken())));
        }

        return issues;
    }
}
