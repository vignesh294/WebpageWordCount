package com.util.webpage.words;

import com.util.webpage.Webpage;

public class WordsPerWebpage extends Webpage implements Runnable {
    private String wordToCount;
    private WordCount globalWordCount;
    private long pagewiseWordCount = 0L;

    public WordsPerWebpage(String wordToCount, String url, WordCount globalWordCount) {
        super(url);
        this.wordToCount = wordToCount;
        this.globalWordCount = globalWordCount;
    }

    public long loadAndCountWords() {
        loadPage();
        this.pagewiseWordCount = countWords();
        globalWordCount.incrementCountBy(pagewiseWordCount);
        return pagewiseWordCount;
    }

    private long countWords() {
        int index = this.response.indexOf(wordToCount);
        long count = 0L;
        while (index != -1) {
            count++;
            this.response = this.response.substring(index + 1);
            index = this.response.indexOf("is");
        }
        return count;
    }

    public void run() {
        loadAndCountWords();
    }

    public String toString() {
        return "WordsPerWebpage(" + this.url_string + ", " + wordToCount + ", " + pagewiseWordCount +")";
    }
}
