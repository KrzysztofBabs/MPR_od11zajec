package com.example.zajecia2.repository;

import com.example.zajecia2.model.Auto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface AutoRepository extends CrudRepository<Auto,Long>{
     List<Auto> findByModel(String model);
     Optional<Auto> findById(Long Id);

     List<Auto> findByIdentyfikator(int identyfikator);
     List<Auto> findByRokProdukcji(int rokProdukcji);
     List<Auto> findAll();







}
