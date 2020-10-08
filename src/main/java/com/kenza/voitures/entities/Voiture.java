package com.kenza.voitures.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Voiture {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idVoiture;
private String marque;
private Double prix;
private Date dateFabrication;
public Voiture(String marque, Double prix, Date dateFabrication) {
	super();
	this.marque = marque;
	this.prix = prix;
	this.dateFabrication = dateFabrication;
}
public Voiture() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getIdVoiture() {
	return idVoiture;
}
public void setIdVoiture(Long idVoiture) {
	this.idVoiture = idVoiture;
}
public String getMarque() {
	return marque;
}
public void setMarque(String marque) {
	this.marque = marque;
}
public Double getPrix() {
	return prix;
}
public void setPrix(Double prix) {
	this.prix = prix;
}
public Date getDateFabrication() {
	return dateFabrication;
}
public void setDateFabrication(Date dateFabrication) {
	this.dateFabrication = dateFabrication;
}
@Override
public String toString() {
	return "Voiture [idVoiture=" + idVoiture + ", marque=" + marque + ", prix=" + prix + ", dateFabrication="
			+ dateFabrication + "]";
}
}
