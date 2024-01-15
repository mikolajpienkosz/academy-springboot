package com.accenture.academy.priest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class PriestRepository {
    private final IPriestRepository iPriestRepository;

    List<PriestDao> findAll(){
        return iPriestRepository.findAll();
    }

    void save(PriestDao priestDao){
        iPriestRepository.save(priestDao);
    }
}
