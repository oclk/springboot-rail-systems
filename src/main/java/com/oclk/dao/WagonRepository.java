package com.oclk.dao;

import com.oclk.entity.Wagon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WagonRepository extends JpaRepository<Wagon, Integer> {
}
