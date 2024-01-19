package com.accenture.academy.priest;

import com.accenture.academy.church.ChurchNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    ResponseEntity<?> getPriestById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(priestService.getPriestById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void addPriest(@RequestBody @Valid PriestDto priestDto){
        priestService.addPriestDto(priestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updatePriest(@RequestBody PriestDto priestDto, @PathVariable Long id){
        priestService.update(priestDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePriestById(@PathVariable Long id){
        priestService.deleteById(id);
    }

    @GetMapping("/byName/{name}")
    ResponseEntity<?> getPriestsByName(@PathVariable String name){
        try {
            return ResponseEntity.status(200).body(priestService.getPriestByName(name));
        } catch (NoSuchPriestsFoundException exception){
            return ResponseEntity.status(404).body(exception.getMessage());
        }
    }
}
