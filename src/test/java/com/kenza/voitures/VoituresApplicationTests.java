package com.kenza.voitures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.kenza.voitures.entities.Voiture;
import com.kenza.voitures.repos.VoitureRepository;
import com.kenza.voitures.service.VoitureService;

@SpringBootTest
class VoituresApplicationTests {
	@Autowired
	private VoitureRepository voitureRepository;
	@Autowired
	private VoitureService voitureService;
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
	public void testFindByNomVoitureContains()
	{
	Page<Voiture> prods =voitureService.getAllVoituresParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements()); 
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */

	}
}
