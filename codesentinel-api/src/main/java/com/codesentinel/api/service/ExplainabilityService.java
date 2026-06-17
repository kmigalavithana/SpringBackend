package com.codesentinel.api.service;

import java.util.Map;

public class ExplainabilityService {

    public String explain(
            String prediction,
            Map<String, Integer> features
    ) {

        // 🛡️ 1. SQL Injection XAI Explanation
        if (prediction.equals("SQL Injection")) {
            return "Detected because rawQuery and string concatenation were found.";
        }

        // 🛡️ 2. Certificate Validation XAI Explanation (Updated)
        if (prediction.equals("Certificate Validation")) {
            // 🚀 XAI එකෙන් developer ට පැහැදිලි කරනවා හිස් TrustManager එකක් හෝ HostnameVerifier true කරපු නිසයි මේක අහුවුණේ කියලා
            return "The ML model detected an active bypassTrigger alongside SSL configurations. This indicates an explicit choice to return 'true' or leave verification methods empty, triggering high risk for Man-in-the-Middle (MitM) attacks.";
        }

        return "No suspicious pattern detected.";
    }
}