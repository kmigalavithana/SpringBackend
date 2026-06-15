package com.codesentinel.api.service;

import java.util.HashMap;
import java.util.Map;

public class FeatureExtractor {

    public Map<String, Integer> extract(String code) {

        System.out.println("CODE = " + code);

        Map<String, Integer> features =
                new HashMap<>();

        features.put(
                "rawQueryCount",
                countOccurrences(code, "rawQuery(")
        );

        features.put(
                "stringConcatenation",
                countOccurrences(code, "+")
        );

        features.put(
                "hostnameVerifierCount",
                countOccurrences(
                        code,
                        "HostnameVerifier"
                )
        );

        features.put(
                "trustManagerCount",
                countOccurrences(
                        code,
                        "TrustManager"
                )
        );

        System.out.println("FEATURES = " + features);

        return features;
    }

    private int countOccurrences(
            String text,
            String keyword
    ) {

        int count = 0;
        int index = 0;

        while (
                (index = text.indexOf(
                        keyword,
                        index
                )) != -1
        ) {
            count++;
            index += keyword.length();
        }

        return count;
    }
}