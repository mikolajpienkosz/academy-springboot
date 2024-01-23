//package com.accenture.academy.parish;
//
//import com.accenture.academy.church.ChurchService;
//import com.accenture.academy.member.MemberDao;
//import com.accenture.academy.priest.PriestService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//@RequiredArgsConstructor
//public class ParishDataInitializer {
//    private final ParishService parishService;
//    private final ChurchService churchService;
//    private final PriestService priestService;
//
//    @EventListener(ApplicationReadyEvent.class)
//    void initParish(){
//        MemberDao memberDao1 = new MemberDao(
//                "Andrzej",
//                "Duda",
//                "1970-10-10"
//        );
//        MemberDao memberDao2 = new MemberDao(
//                "Agata",
//                "Duda",
//                "1971-10-10"
//        );
//
//        ParishDao parishDao = new ParishDao(
//                "Parafia Jana Pawła 2 w Wadowicach",
//                priestService.getPriestById(1L),
//                churchService.getChurchById(1L),
//                Set.of(memberDao1, memberDao2),
//                null
//        );
//
//        parishService.addParish(parishDao);
//    }
//}
