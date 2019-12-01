package com.martinvana.censorship.model;

import com.martinvana.stringsearch.Hits;

import java.util.Map;
import java.util.SortedSet;

/**
 * Issues in a document.
 */
public class Issues {

    /**
     * Number of issues.
     */
    private int size;

    /**
     * Map {@literal <pattern, set-of-positions>}.
     */
    private Map<String, SortedSet<Integer>> hits;

    /**
     * @param hits Search hits.
     */
    public Issues(Hits hits) {
        this.size = hits.size();
        this.hits = hits.hits();
    }

    public int getSize() {
        return size;
    }

    public Map<String, SortedSet<Integer>> getHits() {
        return hits;
    }
}
