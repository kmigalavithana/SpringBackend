package com.codesentinel.api.model;

public class ScanResult {

    private String prediction;
    private String explanation;
    private int confidence;

    public ScanResult(
            String prediction,
            String explanation,
            int confidence
    ) {
        this.prediction = prediction;
        this.explanation = explanation;
        this.confidence = confidence;
    }

    public String getPrediction() {
        return prediction;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getConfidence() {
        return confidence;
    }
}