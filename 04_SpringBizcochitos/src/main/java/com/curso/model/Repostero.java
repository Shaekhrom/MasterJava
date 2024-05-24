package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
@Entity
@NamedQueries({
    @NamedQuery(
        name = "Repostero.countByAgeBetween20And30",
        query = "SELECT COUNT(r) FROM Repostero r WHERE r.edad BETWEEN 20 AND 30"
    ),
    @NamedQuery(
        name = "Repostero.findAverageSalary",
        query = "SELECT AVG(r.salario) FROM Repostero r"
    )
})
public class Repostero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;
    
    private String nombre;
    private int edad;
    private double salario;
    
    

    public Repostero() {
		super();
	}


	public Repostero(String nombre, int edad, double salario) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}


    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


	@Override
	public int hashCode() {
		return Objects.hash(idEmpleado);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repostero other = (Repostero) obj;
		return idEmpleado == other.idEmpleado;
	}
    
}
