package com.accenture.academy.priest;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PriestDataInitializer {
    private final PriestService priestService;

    @PostConstruct
    void initPriests(){
        PriestDao priestDao = new PriestDao("Karol", 178L, 85L);
        PriestDao priestDao1 = new PriestDao("Stefan", 177L, 80L);
        PriestDao priestDao2 = new PriestDao("Tadeusz", 151L, 78L);

        priestService.addPriest(priestDao);
        priestService.addPriest(priestDao1);
        priestService.addPriest(priestDao2);
    }
}
