package com.accenture.academy.parish;


import com.accenture.academy.cemetery.CemeteryDao;
import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.priest.PriestDao;

class ParishMapper {
    static ParishDao mapDtoToDao(ParishDto parishDto, PriestDao priestDao, ChurchDao churchDao){
        ParishDao parishDao = new ParishDao();
        parishDao.setParishName(parishDto.getParishName());
        parishDao.setPriestDao(priestDao);
        parishDao.setChurchDao(churchDao);
        parishDao.setMembers(parishDto.getMembers());
        parishDao.setCemeteryDao(new CemeteryDao());
        return parishDao;
    }
}
