package com.bridgeLabz.bufferReaderFileReader;

import java.io.*;
import java.util.*;

public class WordCountFiveTop {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgeLabz/bufferReaderFileReader/Sample.txt"; // Change this to your file path
        countTopWords(filePath);
    }

    public static void countTopWords(String filePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display the top 5 most frequent words
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getKey() + " -> " + sortedWords.get(i).getValue() + " times");
        }
    }
}
