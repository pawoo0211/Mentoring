package com.example.mentoring.menu.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MenuRepository extends JpaRepository<Menu, Long> {

    Optional<Menu> findByMenu(String menu);
}
