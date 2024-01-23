package com.accenture.academy.parish;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.church.ChurchService;
import com.accenture.academy.priest.PriestDao;
import com.accenture.academy.priest.PriestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParishService {
    private final ParishRepository parishRepository;
    private final ChurchService churchService;
    private final PriestService priestService;

    public void addParish(ParishDto parishDto) {
        ChurchDao churchDao = churchService.getChurchById(parishDto.getChurchId());
        PriestDao priestDao = priestService.getPriestById(parishDto.getPriestId());
        ParishDao parishDao = ParishMapper.mapDtoToDao(parishDto, priestDao, churchDao);

        parishRepository.saveParish(parishDao);
    }

    public void addParish(ParishDao parishDao) {
        parishRepository.saveParish(parishDao);
    }

    public List<ParishDao> getAllParishes() {
        return parishRepository.findAllParishes();
    }

    public void assignPriestToParish(PriestAssignmentDto priestAssignmentDto, Long parishId) {
        ParishDao parishDao = getById(parishId);
        PriestDao priestDao = priestService.getPriestById(priestAssignmentDto.getPriestId());

        parishDao.setPriestDao(priestDao);
        parishRepository.saveParish(parishDao);
    }

    ParishDao getById(Long id){
        return parishRepository.findById(id).orElseThrow(() -> new RuntimeException("Parish with id "+ id+" doesn't exist"));
    }
}
