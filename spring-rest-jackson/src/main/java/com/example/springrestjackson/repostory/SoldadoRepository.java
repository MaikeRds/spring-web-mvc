package com.example.springrestjackson.repostory;


import com.example.springrestjackson.entity.SoldadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldadoRepository extends JpaRepository<SoldadoEntity, Long> {
}
