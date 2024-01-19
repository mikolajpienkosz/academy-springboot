package com.accenture.academy.ipinfoservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class IpInfoRepository {
    private final IIpInfoRepository ipInfoRepository;

    void save(IpInfoDao ipInfoDao){
        ipInfoRepository.save(ipInfoDao);
    }
}
