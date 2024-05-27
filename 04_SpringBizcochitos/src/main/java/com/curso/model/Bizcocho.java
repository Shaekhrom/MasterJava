package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
@Entity
@Table(name = "bizcocho")
public class Bizcocho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBizcocho;
    
    private int idRepostero;
    private String nombreBizcocho;
    private boolean esVegano;
    private double precioBizcocho;
    
    

    public Bizcocho() {
		super();
	}


	public Bizcocho(int idRepostero, String nombreBizcocho, boolean esVegano, double precioBizcocho) {
		super();
		this.idRepostero = idRepostero;
		this.nombreBizcocho = nombreBizcocho;
		this.esVegano = esVegano;
		this.precioBizcocho = precioBizcocho;
	}
	
	
    public Bizcocho(int idBizcocho) {
		super();
		this.idBizcocho = idBizcocho;
	}


	public int getIdBizcocho() {
        return idBizcocho;
    }

    public void setIdBizcocho(int idBizcocho) {
        this.idBizcocho = idBizcocho;
    }

    public int getIdRepostero() {
        return idRepostero;
    }

    public void setIdRepostero(int idRepostero) {
        this.idRepostero = idRepostero;
    }

    public String getNombreBizcocho() {
        return nombreBizcocho;
    }

    public void setNombreBizcocho(String nombreBizcocho) {
        this.nombreBizcocho = nombreBizcocho;
    }

    public boolean isEsVegano() {
        return esVegano;
    }

    public void setEsVegano(boolean esVegano) {
        this.esVegano = esVegano;
    }

    public double getPrecioBizcocho() {
        return precioBizcocho;
    }

    public void setPrecioBizcocho(double precioBizcocho) {
        this.precioBizcocho = precioBizcocho;
    }


	@Override
	public int hashCode() {
		return Objects.hash(idBizcocho);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bizcocho other = (Bizcocho) obj;
		return idBizcocho == other.idBizcocho;
	}
    
    
}
