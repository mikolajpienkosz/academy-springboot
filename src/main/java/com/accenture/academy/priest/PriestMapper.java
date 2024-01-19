package com.accenture.academy.priest;

public class PriestMapper {
    public PriestDao mapDtoToDao(PriestDto priestDto) {
        PriestDao priestDao = new PriestDao();
        priestDao.setName(priestDto.getName());
        priestDao.setAge(priestDto.getAge());
        priestDao.setHeight(priestDto.getHeight());

        return priestDao;
    }

    public PriestDao mapDtoToDao(PriestDto priestDto, Long id) {
        PriestDao priestDao = new PriestDao();
        priestDao.setId(id);
        priestDao.setName(priestDto.getName());
        priestDao.setAge(priestDto.getAge());
        priestDao.setHeight(priestDto.getHeight());

        return priestDao;
    }
}
