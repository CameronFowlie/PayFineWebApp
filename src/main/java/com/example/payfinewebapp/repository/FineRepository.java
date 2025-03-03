package com.example.payfinewebapp.repository;

import com.example.payfinewebapp.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends JpaRepository<Fine, Long>
{
}
