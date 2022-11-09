package com.example.mentoring.menu.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MenuEntityRepository extends JpaRepository<MenuEntity, Long> {

    Optional<MenuEntity> findByMenu(String menu);
    boolean existsByMenu(String menu);
}
