package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChurchService {
    private final ChurchRepository churchRepository;
    private final ChurchMapper churchMapper = new ChurchMapper();

    List<ChurchDao> getAllChurches() {
        return churchRepository.findAll();
    }

    void addChurch(ChurchDao churchDao){
        churchRepository.save(churchDao);
    }
    void addChurchDto(ChurchDto churchDto){
        churchRepository.save(churchMapper.mapDtoToDao(churchDto));
    }

    public ChurchDao getChurchById(Long id) {
        return churchRepository.findById(id).orElseThrow(
                () -> new ChurchNotFoundException("Church with id " + id + " not found"));
    }

    void update(ChurchDto churchDto, Long id) {
        churchRepository.save(churchMapper.mapDtoToDao(churchDto, id));
    }

    void deleteById(Long id) {
        churchRepository.deleteById(id);
    }

    List<ChurchDao> getAllByName(Optional<String> name) {
        return churchRepository.findAllByName(name);
    }
}
