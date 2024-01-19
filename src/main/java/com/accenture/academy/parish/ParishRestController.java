package com.accenture.academy.parish;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parishes")
@RequiredArgsConstructor
public class ParishRestController {
    private final ParishService parishService;

    @GetMapping
    List<ParishDao> getAllParishes(){
        return parishService.getAllParishes();
    }

    @PostMapping
    void addParish(@RequestBody ParishDto parishDto){
        parishService.addParish(parishDto);
    }
}
