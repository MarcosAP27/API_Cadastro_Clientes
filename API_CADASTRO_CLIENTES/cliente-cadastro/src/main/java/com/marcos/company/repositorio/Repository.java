package com.marcos.company.repositorio;

import com.marcos.company.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository <Cliente, Integer> {
}
