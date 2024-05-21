package jpa1;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity

@NamedQueries({
	
	@NamedQuery(name="mostrarTodosAlumnos", query="SELECT a FROM Alumno a"),
	@NamedQuery(name="alumnosApellidoEmpiezaConG", query="SELECT a FROM Alumno a WHERE a.apellido LIKE 'G%' "),
	@NamedQuery(name="alumnosMatriculadosEnHistoria", query="SELECT a FROM Alumno a WHERE a.curso = :curso"),
	@NamedQuery(name="codigoEntreDosValores", query="SELECT a FROM Alumno a WHERE a.codigo BETWEEN 10 AND 17")

})

public class Alumno implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private String apellido;
	private String curso;
	
	
	public Alumno() {
    }

	
    public Alumno(String nombre, String apellido, String curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", curso=" + curso + "]";
	}
	
    
}
