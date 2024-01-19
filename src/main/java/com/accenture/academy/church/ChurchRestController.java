package com.accenture.academy.church;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.server.Cookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/churches")
@RequiredArgsConstructor
class ChurchRestController {
    private final ChurchService churchService;

    @GetMapping
    List<ChurchDao> getAllChurches(@RequestParam(required = false) Optional<String> name) {
        if (name.isPresent()){
            return churchService.getAllByName(name);
        }
        return churchService.getAllChurches();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getAChurchById(@PathVariable Long id) {
        try{
            return ResponseEntity.status(200)
                    .header("eluwina", "byku")
                    .body(churchService.getChurchById(id));
        }catch (ChurchNotFoundException exception){
            return ResponseEntity.status(404).body(exception.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void addChurch(@RequestBody @Valid ChurchDto churchDto){
        churchService.addChurchDto(churchDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateChurch(@RequestBody ChurchDto churchDto, @PathVariable Long id){
        churchService.update(churchDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteChurchById(@PathVariable Long id){
        churchService.deleteById(id);
    }
}
