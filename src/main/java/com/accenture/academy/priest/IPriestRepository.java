package com.accenture.academy.priest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface IPriestRepository extends JpaRepository<PriestDao, Long> {
    List<PriestDao> findByName(String name);
}
