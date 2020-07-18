package com.util;

import com.util.webpage.words.WordCount;
import com.util.webpage.words.WordsPerWebpage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // take input of no of pages and the pages
        // take input of word to count
        String wordToCount = "coronavirus";
        WordCount globalWordCount = new WordCount(wordToCount);
        String url1 = "https://news.google.com/topstories";
        String url2 = "https://www.bbc.com";
        String url3 = "https://www.rediff.com/news";
        String url4 = "https://edition.cnn.com";
        WordsPerWebpage wordsPerWebpage1 = new WordsPerWebpage(wordToCount, url1, globalWordCount);
        WordsPerWebpage wordsPerWebpage2 = new WordsPerWebpage(wordToCount, url2, globalWordCount);
        WordsPerWebpage wordsPerWebpage3 = new WordsPerWebpage(wordToCount, url3, globalWordCount);
        WordsPerWebpage wordsPerWebpage4 = new WordsPerWebpage(wordToCount, url4, globalWordCount);

        Thread t1 = new Thread(wordsPerWebpage1); t1.start();
        Thread t2 = new Thread(wordsPerWebpage2); t2.start();
        Thread t3 = new Thread(wordsPerWebpage3); t3.start();
        Thread t4 = new Thread(wordsPerWebpage4); t4.start();

        t1.join(); t2.join(); t3.join(); t4.join();

        System.out.println("Done.");
    }
}
