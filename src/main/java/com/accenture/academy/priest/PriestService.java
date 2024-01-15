package com.accenture.academy.priest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriestService {
    private final PriestRepository priestRepository;

    List<PriestDao> getAllPriests(){
        return priestRepository.findAll();
    }

    void addPriest(PriestDao priestDao){
        priestRepository.save(priestDao);
    }
}
