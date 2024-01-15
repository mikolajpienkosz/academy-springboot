package com.accenture.academy.priest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/priests")
@RequiredArgsConstructor
class PriestRestController {
    private final PriestService priestService;

    @GetMapping
    List<PriestDao> getAllPriests(){
        return priestService.getAllPriests();
    }
}
