package com.codesentinel.api.service;

import java.util.Map;

public class ExplainabilityService {

    public String explain(
            String prediction,
            Map<String, Integer> features
    ) {

        if (prediction.equals("SQL Injection")) {

            return "Detected because rawQuery and string concatenation were found.";
        }

        if (prediction.equals("Certificate Validation")) {

            return "Detected because HostnameVerifier always returns true.";
        }

        return "No suspicious pattern detected.";
    }
}