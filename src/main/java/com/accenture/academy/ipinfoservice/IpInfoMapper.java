package com.accenture.academy.ipinfoservice;

class IpInfoMapper {
    IpInfoDao mapDtoToDao(IpInfoDto ipInfoDto) {
        IpInfoDao ipInfoDao = new IpInfoDao();
        ipInfoDao.setIp(ipInfoDto.getIp());
        ipInfoDao.setCity(ipInfoDto.getCity());
        ipInfoDao.setRegion(ipInfoDto.getRegion());
        ipInfoDao.setCountry(ipInfoDto.getCountry());
        ipInfoDao.setLoc(ipInfoDto.getLoc());
        ipInfoDao.setOrg(ipInfoDto.getOrg());
        ipInfoDao.setPostal(ipInfoDto.getPostal());
        ipInfoDao.setTimezone(ipInfoDto.getTimezone());
        ipInfoDao.setRegion(ipInfoDto.getRegion());

        return ipInfoDao;
    }
}
