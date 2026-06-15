package com.codesentinel.api.model;

public class ScanResult {

    private String prediction;
    private String explanation;

    public ScanResult(
            String prediction,
            String explanation
    ) {
        this.prediction = prediction;
        this.explanation = explanation;
    }

    public String getPrediction() {
        return prediction;
    }

    public String getExplanation() {
        return explanation;
    }
}