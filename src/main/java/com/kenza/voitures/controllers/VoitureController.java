package com.kenza.voitures.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kenza.voitures.entities.Voiture;
import com.kenza.voitures.service.VoitureService;

@Controller
public class VoitureController {
	
	@Autowired
	VoitureService voitureService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createVoiture";
	}
	@RequestMapping("/saveVoiture")
	public String saveVoiture(@ModelAttribute("voiture") Voiture voiture,@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateFabrication = dateformat.parse(String.valueOf(date));
	voiture.setDateFabrication(dateFabrication);
	Voiture saveVoiture = voitureService.saveVoiture(voiture);
	String msg ="produit enregistré avec Id "+saveVoiture.getIdVoiture();
	modelMap.addAttribute("msg", msg);
	return "createVoiture";
	}
	@RequestMapping("/ListeVoitures")
	public String listeVoitures(ModelMap modelMap)
	{
	List<Voiture> voit = voitureService.getAllVoitures();
	modelMap.addAttribute("voitures", voit);
	return "listeVoitures";
	}
	@RequestMapping("/supprimerVoiture")
	public String supprimerVoiture(@RequestParam("id") Long id,
	ModelMap modelMap)
	{
	voitureService.deleteVoitureById(id);
	List<Voiture> prods = voitureService.getAllVoitures();
	modelMap.addAttribute("voitures", prods);
	return "listeVoitures";
	}
	@RequestMapping("/modifierVoiture")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Voiture v= voitureService.getVoiture(id);
	modelMap.addAttribute("voiture", v);
	return "editerVoiture";
	}
	@RequestMapping("/updateVoiture")
	public String updateProduit(@ModelAttribute("voiture") Voiture voiture,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date 
	SimpleDateFormat  dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateFabrication = dateformat.parse(String.valueOf(date));
	voiture.setDateFabrication(dateFabrication);
	voitureService.updateVoiture(voiture);
	List<Voiture> prods = voitureService.getAllVoitures();
	modelMap.addAttribute("voitures", prods);
	return "listeVoitures";
	}
}
