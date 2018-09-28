package com.example.springboot.repository;

import com.example.springboot.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,String>{
    public List<Girl> findByAge(int age);
}
