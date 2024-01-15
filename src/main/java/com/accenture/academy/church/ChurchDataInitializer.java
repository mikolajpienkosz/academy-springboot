package com.accenture.academy.church;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ChurchDataInitializer {
    private final ChurchService churchService;

    @PostConstruct
    void initChurches(){
        ChurchDao churchDao = new ChurchDao("Kościół św. krzyża", "Warszawa", 150, 10000, 20000.00);
        ChurchDao churchDao1 = new ChurchDao("Kościół św. Stanisława", "Łódź", 250, 7000, 10000.00);
        ChurchDao churchDao2 = new ChurchDao("Kościół św. Rodziny", "Radom", 50, 100000, 5000.00);

        churchService.addChurch(churchDao);
        churchService.addChurch(churchDao1);
        churchService.addChurch(churchDao2);
    }
}
