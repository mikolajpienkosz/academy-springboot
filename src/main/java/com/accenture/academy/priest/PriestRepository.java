package com.accenture.academy.priest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    Optional<PriestDao> findById(Long id) {
        return iPriestRepository.findById(id);
    }

    void deleteById(Long id) {
        iPriestRepository.deleteById(id);
    }

    List<PriestDao> findByName(String name){
        return iPriestRepository.findByName(name);
    }
}
