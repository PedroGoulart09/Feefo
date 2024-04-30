package com.testInterview.Normaliser;

public class EditDistanceCalculator {
    public int calculateEditDistance(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // Initialize a 1D array for dynamic programming
        int[] dp = new int[len2 + 1];

        // Initialize the first row
        for (int j = 0; j <= len2; j++) dp[j] = j;

        // Fill the dp array
        for (int i = 1; i <= len1; i++) {
            int prev = i;
            for (int j = 1; j <= len2; j++) {
                int temp = dp[j];
                dp[j] = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? prev - 1 : Math.min(prev, Math.min(dp[j], dp[j - 1])) + 1;
                prev = temp;
            }
        }

        // Return the edit distance
        return dp[len2];
    }
}