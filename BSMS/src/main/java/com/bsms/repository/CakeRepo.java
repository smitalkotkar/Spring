package com.bsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.bsms.entity.Cake;

public interface CakeRepo  extends JpaRepository<Cake, Integer> {

}
