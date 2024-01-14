package com.example.personel.repository;

import com.example.personel.entity.PersonelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelRepository extends JpaRepository<PersonelEntity, Long> {
    public abstract <S extends T> S save(     S entity );
}
