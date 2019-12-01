package com.martinvana.censorship.model;

/**
 * A document to scan for inappropriate words.
 */
public class Document {

    /**
     * Heading.
     */
    private String heading;

    /**
     * Main text.
     */
    private String text;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
