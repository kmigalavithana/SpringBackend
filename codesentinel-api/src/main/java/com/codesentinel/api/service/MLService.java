package com.codesentinel.api.service;

import java.util.Map;

public class MLService {

    public String predict(Map<String, Integer> features) {
        System.out.println("========== ML INPUT ==========");
        System.out.println(features);

        int rawQueryCount = features.getOrDefault("rawQueryCount", 0);
        int stringConcatenation = features.getOrDefault("stringConcatenation", 0);
        int hostnameVerifierCount = features.getOrDefault("hostnameVerifierCount", 0);
        int trustManagerCount = features.getOrDefault("trustManagerCount", 0);
        int bypassTrigger = features.getOrDefault("bypassTrigger", 0);

        System.out.println("rawQueryCount = " + rawQueryCount);
        System.out.println("stringConcatenation = " + stringConcatenation);
        System.out.println("hostnameVerifierCount = " + hostnameVerifierCount);
        System.out.println("trustManagerCount = " + trustManagerCount);
        System.out.println("bypassTrigger = " + bypassTrigger);

        // 🛡️ 1. SQL Injection Prediction Logic
        if (rawQueryCount > 0 && stringConcatenation > 0) {
            System.out.println("Prediction = SQL Injection");
            return "SQL Injection";
        }

        // 🛡️ 2. Certificate Validation Prediction Logic (With Bypass Trigger)
        if ((hostnameVerifierCount > 0 || trustManagerCount > 0) && bypassTrigger > 0) {
            System.out.println("Prediction = Certificate Validation");
            return "Certificate Validation";
        }

        System.out.println("Prediction = None");
        return "None";
    }
}