//package dev.habil.apigw.controller;
//
//import dev.habil.apigw.data.ApiGWReimportRequest;
//import dev.habil.apigw.service.ApiGWService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/sync")
//public class ApiGWController {
//
//    private final ApiGWService service;
//
//    @PostMapping
//    public String sync(@RequestBody ApiGWReimportRequest request) {
//        service.syncSwaggerToApiGW(request);
//        return "Completed";
//    }
//}