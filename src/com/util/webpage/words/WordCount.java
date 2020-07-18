package com.util.webpage.words;

public class WordCount {
    private String word;
    private long count = 0L;

    public WordCount(String word){
        this.word = word;
    }

    public synchronized void incrementCountBy(long number) {
        count += number;
    }

    public String toString() {
        return "WordCount(" + this.word + ", " + count + ")";
    }
}
