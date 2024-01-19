package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
class ChurchRepository {
    private final IChurchRepository iChurchRepository;

    List<ChurchDao> findAll() {
        return iChurchRepository.findAll();
    }

    void save(ChurchDao churchDao) {
        iChurchRepository.save(churchDao);
    }

    Optional<ChurchDao> findById(Long id) {
        return iChurchRepository.findById(id);
    }

    void deleteById(Long id) {
        iChurchRepository.deleteById(id);
    }

    public List<ChurchDao> findAllByName(Optional<String> name) {
        return iChurchRepository.findAllByNameContaining(name);
    }
}
