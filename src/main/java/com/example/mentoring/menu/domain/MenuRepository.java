package com.example.mentoring.menu.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu,Long> {

    Optional<Boolean> findByMenu(String Menu);


}
