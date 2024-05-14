package com.study.deploy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthCheckController {

    // .yml 에 있는 것을 가져옴
    @Value("${server.env}")
    private String env;

    @Value("${server.name}")
    private String serverName;

    @Value("${server.deploy-address}")
    private String deployAddress;

    @Value("${server.port}")
    private String port;

    @GetMapping("/server/hc")
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok(Map.of("serverName", serverName, "deployAddress", deployAddress, "port", port));
    }

    // 자동 ci/cd 할 때 blue 인지 green 인지 확인 용도
    @GetMapping("/server/env")
    public ResponseEntity<?> getEnv() {
        return ResponseEntity.ok(env);
    }
}
