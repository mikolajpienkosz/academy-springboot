package com.accenture.academy.priest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriestService {
    private final PriestRepository priestRepository;
    private final PriestMapper priestMapper = new PriestMapper();

    List<PriestDao> getAllPriests(){
        return priestRepository.findAll();
    }

    public PriestDao getPriestById(Long id){
        return priestRepository.findById(id).orElseThrow(
                () -> new PriestNotFoundException("Priest with id "+id+" not found")
        );
    }

    public void addPriest(PriestDao priestDao){
        priestRepository.save(priestDao);
    }

    void addPriestDto(PriestDto priestDto) {
        priestRepository.save(priestMapper.mapDtoToDao(priestDto));
    }

    void update(PriestDto priestDto, Long id) {
        priestRepository.save(priestMapper.mapDtoToDao(priestDto, id));
    }

    void deleteById(Long id) {
        priestRepository.deleteById(id);
    }

    List<PriestDao> getPriestByName(String name) {
        List<PriestDao> result = priestRepository.findByName(name);
        if (result.isEmpty()) throw new NoSuchPriestsFoundException("No priests with name "+name+" have been found");
        return result;
    }
}
