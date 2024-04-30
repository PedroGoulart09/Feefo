package com.testInterview.Normaliser;

import java.util.HashMap;
import java.util.Map;

public class Normaliser {
    // Map to store normalized job titles
    private static final Map<String, String> normalizedTitles = new HashMap<>();
    private static final SimilarityCalculator similarityCalculator = new SimilarityCalculator();

    static {
        // Populate the map with known job titles
        normalizedTitles.put("Software engineer", "Software engineer");
        normalizedTitles.put("Architect", "Architect");
        normalizedTitles.put("Accountant", "Accountant");
        normalizedTitles.put("Quantity surveyor", "Quantity surveyor");
    }

    public String normalise(String inputTitle) {
        double maxScore = 0.0;
        String bestMatch = null;

        // Iterate over all known job titles
        for (String normalizedTitle : normalizedTitles.keySet()) {
            // Calculate the similarity score between the input title and the current known title
            double score = similarityCalculator.calculateSimilarity(inputTitle, normalizedTitle);
            // If the score is higher than the current max score, update the max score and best match
            if (score > maxScore) {
                maxScore = score;
                bestMatch = normalizedTitles.get(normalizedTitle);
            }
        }


        double value = Math.round(maxScore * 10) / 10.0;
        // If the similarity score is less than 0.8, return "Unknown Job Title"
        if(value <= 0.8){
            bestMatch = "Unknown Job Title";
        }


        // Return the best match found
        return bestMatch;
    }

}