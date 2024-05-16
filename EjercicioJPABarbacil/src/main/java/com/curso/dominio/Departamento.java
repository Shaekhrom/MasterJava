package com.curso.dominio;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="departamentos")
public class Departamento implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dept;
    private String nombre;
    private String localidad;
    
    @OneToMany(mappedBy = "departamento")
    private List<Empleado> empleados;


    // Constructor por defecto
    public Departamento() {}

    // Constructor con parámetros
    public Departamento(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
    }

    // Getters y setters
    public int getIdDept() {
        return id_dept;
    }

    public void setIdDept(int idDept) {
        this.id_dept = idDept;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}

