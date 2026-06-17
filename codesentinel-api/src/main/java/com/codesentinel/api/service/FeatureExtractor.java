package com.codesentinel.api.service;

import java.util.HashMap;
import java.util.Map;

public class FeatureExtractor {

    public Map<String, Integer> extract(String code) {
        System.out.println("CODE = " + code);

        Map<String, Integer> features = new HashMap<>();

        // === SQL Injection Features ===
        features.put("rawQueryCount", countOccurrences(code, "rawQuery("));
        features.put("stringConcatenation", countOccurrences(code, "+"));

        // === Certificate Validation (SSL) Features ===
        features.put("hostnameVerifierCount", countOccurrences(code, "HostnameVerifier"));
        features.put("trustManagerCount", countOccurrences(code, "TrustManager"));

        // 🚀 XAI එකට වැදගත්ම Feature එක: direct true එකක් දාලා bypass කරනවාද හෝ empty body ද?
        int bypassCount = countOccurrences(code, "return true")
                + countOccurrences(code, "-> true")
                + countOccurrences(code, "{}");
        features.put("bypassTrigger", bypassCount);

        System.out.println("FEATURES = " + features);
        return features;
    }

    private int countOccurrences(String text, String keyword) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }
        return count;
    }
}