package com.codesentinel.api.model;

public class ScanResponse {

    private boolean vulnerable;
    private String vulnerabilityType;
    private String explanation;

    public ScanResponse() {
    }

    public boolean isVulnerable() {
        return vulnerable;
    }

    public void setVulnerable(boolean vulnerable) {
        this.vulnerable = vulnerable;
    }

    public String getVulnerabilityType() {
        return vulnerabilityType;
    }

    public void setVulnerabilityType(String vulnerabilityType) {
        this.vulnerabilityType = vulnerabilityType;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}