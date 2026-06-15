package com.codesentinel.api.service;

import com.codesentinel.api.model.ScanResult;

import java.util.Map;

public class ScanService {

    private final FeatureExtractor extractor =
            new FeatureExtractor();

    private final MLService mlService =
            new MLService();

    private final ExplainabilityService explainabilityService =
            new ExplainabilityService();

    public ScanResult scan(String code) {

        Map<String, Integer> features =
                extractor.extract(code);

        String prediction =
                mlService.predict(features);

        String explanation =
                explainabilityService.explain(
                        prediction,
                        features
                );

        return new ScanResult(
                prediction,
                explanation
        );
    }
}