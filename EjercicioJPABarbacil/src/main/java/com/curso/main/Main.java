package com.curso.main;

import java.util.Date;
import java.util.List;

import com.curso.dominio.Departamento;
import com.curso.dominio.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Main {
	public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empresa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // crear un nuevo departamento
            Departamento nuevoDepartamento = new Departamento("Nuevo Departamento", "Nueva Localidad");
            em.persist(nuevoDepartamento);

            // crear y asignar tres nuevos empleados a ese departamento
            Empleado empleado1 = new Empleado(234,"Empleado 1", new Date(), 2500.00, nuevoDepartamento);
            Empleado empleado2 = new Empleado(235,"Empleado 2", new Date(), 2800.00, nuevoDepartamento);
            Empleado empleado3 = new Empleado(236,"Empleado 3", new Date(), 3000.00, nuevoDepartamento);
            em.persist(empleado1);
            em.persist(empleado2);
            em.persist(empleado3);

            // crear nuevo empleado y asignar 
            Departamento departamentoExistente = em.find(Departamento.class, 1);
            Empleado nuevoEmpleado = new Empleado(237,"Nuevo Empleado", new Date(), 2700.00, departamentoExistente);
            em.persist(nuevoEmpleado);

            //empleado que lleva menos tiempo trabajando en la empresa
            TypedQuery<Empleado> queryMenosTiempo = em.createQuery("SELECT e FROM Empleado e ORDER BY e.fecha ASC", Empleado.class);
            Empleado empleadoMenosTiempo = queryMenosTiempo.setMaxResults(1).getSingleResult();
            System.out.println("Empleado que lleva menos tiempo trabajando en la empresa: " + empleadoMenosTiempo.getNombre());

            //todos departamentos
            TypedQuery<Departamento> queryDepartamentos = em.createQuery("SELECT d FROM Departamento d", Departamento.class);
            List<Departamento> departamentos = queryDepartamentos.getResultList();
            System.out.println("Departamentos:");
            for (Departamento depto : departamentos) {
                System.out.println(depto.getNombre() + " - " + depto.getLocalidad());
            }

            //empleados de un departamento concreto (suponiendo que el departamento tiene id 1)
            TypedQuery<Empleado> queryEmpleadosDepartamento = em.createQuery("SELECT e FROM Empleado e WHERE e.departamento.id_dept = :id_dept", Empleado.class);
            queryEmpleadosDepartamento.setParameter("id_dept", 1);
            List<Empleado> empleadosDepartamento = queryEmpleadosDepartamento.getResultList();
            System.out.println("Empleados del departamento con id 1:");
            for (Empleado emp : empleadosDepartamento) {
                System.out.println(emp.getNombre());
            }

         // departamentos con menos de n empleados (suponiendo que n = 3)
            TypedQuery<Departamento> queryDepartamentos2 = em.createQuery("SELECT d FROM Departamento d WHERE SIZE(d.empleados) < :n", Departamento.class)
            	    .setParameter("n", 3);
            	List<Departamento> departamentosMenosDeNEmpleados = queryDepartamentos2.getResultList();
            	System.out.println("Departamentos con menos de 3 empleados:");
            	for (Departamento depto : departamentosMenosDeNEmpleados) {
            	    System.out.println(depto.getNombre());
            	}



            // empleados que ganan menos que el promedio
            TypedQuery<Double> queryPromedioSueldos = em.createQuery("SELECT AVG(e.sueldo) FROM Empleado e", Double.class);
            Double promedioSueldos = queryPromedioSueldos.getSingleResult();
            TypedQuery<Empleado> queryEmpleadosMenorQuePromedio = em.createQuery("SELECT e FROM Empleado e WHERE e.sueldo < :promedio", Empleado.class);
            queryEmpleadosMenorQuePromedio.setParameter("promedio", promedioSueldos);
            List<Empleado> empleadosMenorQuePromedio = queryEmpleadosMenorQuePromedio.getResultList();
            System.out.println("Empleados que ganan menos que el promedio:");
            for (Empleado emp : empleadosMenorQuePromedio) {
                System.out.println(emp.getNombre());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

