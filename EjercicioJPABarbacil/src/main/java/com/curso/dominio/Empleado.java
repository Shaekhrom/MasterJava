package com.curso.dominio;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private int id_emp;
    private String nombre;
    private Date fecha;
    private double sueldo;

    @ManyToOne
    @JoinColumn(name = "id_dept")
    private Departamento departamento;

    // Constructor por defecto
    public Empleado() {}

    // Constructor con parámetros
    public Empleado(int id_emp, String nombre, Date fecha, double sueldo, Departamento departamento) {
    	this.id_emp = id_emp;
        this.nombre = nombre;
        this.fecha = fecha;
        this.sueldo = sueldo;
        this.departamento = departamento;
    }

    // Getters y setters
    
    public int getid_emp() {
        return id_emp;
    }

    public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public void setid_emp(int idEmp) {
        this.id_emp = idEmp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
