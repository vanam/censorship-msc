package com.martinvana.censorship.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Issues in a document.
 */
public class DocumentIssues {

    /**
     * Issues in a document heading.
     */
    private Issues headingIssues;

    /**
     * Issues in on lines of a document text.
     */
    private Map<Integer, Issues> textIssues = new HashMap<>();

    /**
     * Set issues in a document heading.
     * @param issues Occurrences of censored words in a document heading.
     */
    public void setHeadingIssues(Issues issues) {
        headingIssues = issues;
    }

    /**
     * Set issues in on a line of a document text.
     * @param lineNo Line number.
     * @param issues Occurrences of censored words on a line in a document text.
     */
    public void setTextIssues(int lineNo, Issues issues) {
        textIssues.put(lineNo, issues);
    }

    public Issues getHeadingIssues() {
        return headingIssues;
    }

    public Map<Integer, Issues> getTextIssues() {
        return textIssues;
    }
}
