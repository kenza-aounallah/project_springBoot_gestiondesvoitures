package com.kenza.voitures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kenza.voitures.entities.Voiture;
import com.kenza.voitures.repos.VoitureRepository;

@SpringBootTest
class VoituresApplicationTests {
	@Autowired
	private VoitureRepository voitureRepository;
	@Test
	public void testCreateVoiture() {
	Voiture voit = new Voiture("BMW",2200.500,new Date());
	voitureRepository.save(voit);
	}
	@Test
	public void testFindVoiture()
	{ Voiture v = voitureRepository.findById(1L).get(); 
	System.out.println(v);
	}
	@Test
	public void testUpdateProduit()
	{ Voiture v = voitureRepository.findById(1L).get();
	v.setPrix(1000.0); 
	voitureRepository.save(v);
	}
	@Test
	public void testDeleteProduit()
	{ voitureRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousVoitures()
	{
	List<Voiture> voits = voitureRepository.findAll();
	for (Voiture v : voits)
	{
	System.out.println(v);
	}
	}
	@Test
	void contextLoads() {
	}

}
