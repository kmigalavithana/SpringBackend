package com.codesentinel.api.service;

import com.codesentinel.api.model.ScanResult;
import java.util.Map;

public class ScanService {

    private final FeatureExtractor extractor = new FeatureExtractor();
    private final MLService mlService = new MLService();
    private final ExplainabilityService explainabilityService = new ExplainabilityService();

    public ScanResult scan(String code) {

        // 1. FeatureExtractor එකෙන් bypassTrigger එකත් එක්කම features ටික ගන්නවා
        Map<String, Integer> features = extractor.extract(code);

        System.out.println("EXTRACTED FEATURES = " + features);

        // 2. MLService එකෙන් අලුත් ලොජික් එකට අනුව prediction එක ගන්නවා
        String prediction = mlService.predict(features);

        // 3. ExplainabilityService එකෙන් XAI explanation එක ගන්නවා
        String explanation = explainabilityService.explain(prediction, features);

        int confidence = 0;

        if (prediction.equals("SQL Injection")) {
            confidence = 95;
        }
        // 🚀 Certificate Validation එකට Confidence එක 98% ක් විදිහට අප්ඩේට් කළා
        else if (prediction.equals("Certificate Validation")) {
            confidence = 98;
        }

        return new ScanResult(
                prediction,
                explanation,
                confidence
        );
    }
}