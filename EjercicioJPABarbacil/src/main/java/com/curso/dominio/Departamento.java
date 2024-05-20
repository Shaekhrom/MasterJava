package com.curso.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
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
    
    @OneToMany(mappedBy = "departamento", cascade=CascadeType.ALL)
    private List<Empleado> empleados = new ArrayList<Empleado>();


    // Constructor por defecto
    public Departamento() {}

    // Constructor con parámetros
    public Departamento(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
    }

    
    public Departamento(int id_dept, String nombre, String localidad) {
		super();
		this.id_dept = id_dept;
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

	public int getId_dept() {
		return id_dept;
	}

	public void setId_dept(int id_dept) {
		this.id_dept = id_dept;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_dept);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (empleados == null) {
			if (other.empleados != null)
				return false;
		} else if (!empleados.equals(other.empleados))
			return false;
		if (id_dept != other.id_dept)
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
    
}

