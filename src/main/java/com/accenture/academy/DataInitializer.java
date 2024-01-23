package com.accenture.academy;

import com.accenture.academy.cemetery.CemeteryDao;
import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.church.ChurchService;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.parish.ParishDao;
import com.accenture.academy.parish.ParishService;
import com.accenture.academy.priest.PriestDao;
import com.accenture.academy.priest.PriestService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final ParishService parishService;
    private final ChurchService churchService;
    private final PriestService priestService;

    @PostConstruct
    void initData(){
        MemberDao memberDao1 = new MemberDao(
                "Andrzej",
                "Duda",
                "1970-10-10"
        );
        MemberDao memberDao2 = new MemberDao(
                "Agata",
                "Duda",
                "1971-10-10"
        );
        MemberDao memberDao3 = new MemberDao(
                "Tomasz",
                "Karolak",
                "1975-11-11"
        );

        PriestDao priestDao = new PriestDao("Karol", 178L, 85L);
        PriestDao priestDao1 = new PriestDao("Stefan", 177L, 80L);
        PriestDao priestDao2 = new PriestDao("Tadeusz", 151L, 78L);
        PriestDao priestDao3 = new PriestDao("Janusz", 151L, 78L);


        priestService.addPriest(priestDao);
        priestService.addPriest(priestDao1);
        priestService.addPriest(priestDao2);
        priestService.addPriest(priestDao3);

        ChurchDao churchDao = new ChurchDao("Kościół św. krzyża", "Warszawa", 150, 10000, 20000.00);
        ChurchDao churchDao1 = new ChurchDao("Kościół św. Stanisława", "Łódź", 250, 7000, 10000.00);
        ChurchDao churchDao2 = new ChurchDao("Kościół św. Rodziny", "Radom", 50, 100000, 5000.00);
        ChurchDao churchDao3 = new ChurchDao("Kościół św. Jana Chrzciciela", "Wadowice", 550, 100, 50000.00);


        churchService.addChurch(churchDao);
        churchService.addChurch(churchDao1);
        churchService.addChurch(churchDao2);
        churchService.addChurch(churchDao3);

        ParishDao parishDao = new ParishDao(
                "Parafia Jana Pawła 2 w Wadowicach",
                priestDao2,
                churchDao2,
                Set.of(memberDao1, memberDao2),
                new CemeteryDao()
        );
        ParishDao parishDao2 = new ParishDao(
                "Parafia Jana Pawła 2 w Wadowicach",
                priestDao,
                churchDao1,
                Set.of(memberDao3),
                new CemeteryDao()
        );

        parishService.addParish(parishDao);
        parishService.addParish(parishDao2);
    }

}

