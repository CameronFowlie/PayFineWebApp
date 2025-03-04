package com.example.payfinewebapp.repository;

import com.example.payfinewebapp.entity.Fine;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FineRepository extends JpaRepository<Fine, Long>
{
    Optional<Fine> findByReferenceCodeAndPostcodeAndHouseNo(String refCode, String postcode, String houseNo);
    Optional<Fine> findByReferenceCode(String refCode);

}
