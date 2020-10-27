package com.kenza.voitures;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kenza.voitures.entities.Voiture;
import com.kenza.voitures.service.VoitureService;

@SpringBootApplication
public class VoituresApplication implements CommandLineRunner{
	@Autowired
	VoitureService voitureService;
	public static void main(String[] args) {
	SpringApplication.run(VoituresApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	voitureService.saveVoiture(new Voiture("Nissan Navara",97.5, new Date()));
	voitureService.saveVoiture(new Voiture("Renault Symbol",429.00, new Date()));
	voitureService.saveVoiture(new Voiture("porsche",470.000, new Date()));
	}}
