package com.testInterview.Normaliser;

public class SimilarityCalculator {
    private static final EditDistanceCalculator editDistanceCalculator = new EditDistanceCalculator();

    public double calculateSimilarity(String str1, String str2) {
        // Calculate the maximum length between the two strings
        int maxLength = Math.max(str1.length(), str2.length());

        // Calculate the edit distance between the two strings
        int editDistance = editDistanceCalculator.calculateEditDistance(str1.toLowerCase(), str2.toLowerCase());

        // Calculate the similarity score based on the edit distance and the maximum length

        return 1.0 - ((double) editDistance / maxLength);
    }
}
