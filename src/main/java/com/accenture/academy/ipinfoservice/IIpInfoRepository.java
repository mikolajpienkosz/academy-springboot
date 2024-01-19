package com.accenture.academy.ipinfoservice;

import org.springframework.data.jpa.repository.JpaRepository;

interface IIpInfoRepository extends JpaRepository<IpInfoDao, String> {
}
