package com.example.quind.infrastructure.output.persistence.repository;

import com.example.quind.infrastructure.output.persistence.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {

}