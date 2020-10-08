package com.kenza.voitures.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenza.voitures.entities.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {

}
