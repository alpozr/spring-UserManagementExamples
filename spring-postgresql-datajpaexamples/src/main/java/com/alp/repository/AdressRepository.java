package com.alp.repository;

import com.alp.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdressRepository extends JpaRepository<Adress, Long> {
}
