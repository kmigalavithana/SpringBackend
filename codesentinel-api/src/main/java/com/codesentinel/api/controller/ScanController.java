package com.codesentinel.api.controller;

import com.codesentinel.api.model.ScanRequest;
import com.codesentinel.api.model.ScanResponse;
import com.codesentinel.api.model.ScanResult;
import com.codesentinel.api.service.ScanService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ScanController {

    private final ScanService scanService =
            new ScanService();

    @PostMapping("/scan")
    public ScanResponse scan(
            @RequestBody ScanRequest request
    ) {

        ScanResult result =
                scanService.scan(request.getCode());

        ScanResponse response =
                new ScanResponse();

        response.setVulnerable(
                !result.getPrediction().equals("None")
        );

        response.setVulnerabilityType(
                result.getPrediction()
        );

        response.setExplanation(
                result.getExplanation()
        );

        return response;
    }
}