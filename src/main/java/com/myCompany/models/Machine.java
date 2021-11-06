package com.myCompany.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Machine implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	private String marque;
	private Date dateAchat;
	private double prix;
	
	
	public Machine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Machine(long id, String libelle, String marque, Date dateAchat, double prix) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.marque = marque;
		this.dateAchat = dateAchat;
		this.prix = prix;
	}
	public Machine(String libelle, String marque, Date dateAchat, double prix) {
		super();
		this.libelle = libelle;
		this.marque = marque;
		this.dateAchat = dateAchat;
		this.prix = prix;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Machine [libelle=" + libelle + ", marque=" + marque + "]";
	}
	
	

}
