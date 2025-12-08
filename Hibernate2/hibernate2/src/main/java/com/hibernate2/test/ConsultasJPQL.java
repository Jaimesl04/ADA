package com.hibernate2.test;

import com.hibernate2.entidades.conferencia;
import com.hibernate2.entidades.investigador;
import com.hibernate2.entidades.proyecto;
import jakarta.persistence.EntityManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ConsultasJPQL {
    private EntityManager em;

    public ConsultasJPQL(EntityManager em) {
        this.em = em;
    }

    // a) El nombre de las conferencias cuya duracion sea superior a las dos horas
    public void consultaJPQL1() {
        System.out.println("\n1. Conferencias con duracion superior a 2 horas:");
        try {
            String jpql = "SELECT c.nombre FROM conferencia c WHERE c.numeroHoras > 2.0";
            List<String> resultados = em.createQuery(jpql, String.class).getResultList();

            if (resultados.isEmpty()) {
                System.out.println("   No hay conferencias con duracion superior a 2 horas");
            } else {
                for (String nombre : resultados) {
                    System.out.println("   - " + nombre);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en consulta 1: " + e.getMessage());
        }
    }

    // b) El nombre de los investigadores que participaron en la conferencia de la
    // mayor duracion
    public void consultaJPQL2() {
        System.out.println("\n2. Investigadores que participaron en la conferencia de mayor duracion:");
        try {
            // Conferencia con mayor duracion
            String jpqlMax = "SELECT MAX(c.numeroHoras) FROM conferencia c";
            Double maxHoras = em.createQuery(jpqlMax, Double.class).getSingleResult();

            if (maxHoras != null) {
                String jpql = "SELECT DISTINCT i.nombreCompleto " +
                        "FROM investigador_conferencia ic " +
                        "JOIN ic.investigador i " +
                        "JOIN ic.conferencia c " +
                        "WHERE c.numeroHoras = :maxHoras";

                List<String> resultados = em.createQuery(jpql, String.class)
                        .setParameter("maxHoras", maxHoras)
                        .getResultList();

                if (resultados.isEmpty()) {
                    System.out.println(
                            "   No hay investigadores en la conferencia de mayor duracion (" + maxHoras + " horas)");
                } else {
                    System.out.println("   Conferencia de mayor duracion: " + maxHoras + " horas");
                    for (String nombre : resultados) {
                        System.out.println("   - " + nombre);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error en consulta 2: " + e.getMessage());
        }
    }

    // c) Toda la informacion sobre la conferencia de menor duracion
    public void consultaJPQL3() {
        System.out.println("\n3. Informacion de la conferencia de menor duracion:");
        try {
            String jpqlMin = "SELECT MIN(c.numeroHoras) FROM conferencia c";
            Double minHoras = em.createQuery(jpqlMin, Double.class).getSingleResult();

            if (minHoras != null) {
                String jpql = "SELECT c FROM conferencia c WHERE c.numeroHoras = :minHoras";
                List<conferencia> resultados = em.createQuery(jpql, conferencia.class)
                        .setParameter("minHoras", minHoras)
                        .getResultList();

                if (resultados.isEmpty()) {
                    System.out.println("No hay conferencia con la menor duracion");
                } else {
                    conferencia conf = resultados.get(0);
                    System.out.println("   Nombre: " + conf.getNombre());
                    System.out.println("   Fecha: " + conf.getFechaHoraInicio());
                    System.out.println("   Lugar: " + conf.getLugar());
                    System.out.println("   Horas: " + conf.getNumeroHoras());
                }
            }
        } catch (Exception e) {
            System.out.println("Error en consulta 3: " + e.getMessage());
        }
    }

    // d) Los proyectos llevados a cabo por un determinado investigador
    public void consultaJPQL4() {
        System.out.println("\n4. Proyectos del investigador 'Juan Perez Martinez':");
        try {
            String jpql = "SELECT p.nombre " +
                    "FROM investigador i " +
                    "JOIN i.proyecto p " +
                    "WHERE i.nombreCompleto = :nombreInvestigador";

            List<String> resultados = em.createQuery(jpql, String.class)
                    .setParameter("nombreInvestigador", "Juan Perez Martinez")
                    .getResultList();

            if (resultados.isEmpty()) {
                System.out.println("El investigador no trabaja en ningun proyecto");
            } else {
                for (String proyecto : resultados) {
                    System.out.println("   - " + proyecto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en consulta 4: " + e.getMessage());
        }
    }

    // e) El numero de conferencias en las que ha participado un determinado
    // investigador.
    public void consultaJPQL5() {
        System.out.println("\n5. Numero de conferencias del investigador 'Maria Ruiz Sanchez':");
        try {
            String jpql = "SELECT COUNT(ic) " +
                    "FROM investigador_conferencia ic " +
                    "JOIN ic.investigador i " +
                    "WHERE i.nombreCompleto = :nombreInvestigador";

            Long count = em.createQuery(jpql, Long.class)
                    .setParameter("nombreInvestigador", "Maria Ruiz Sanchez")
                    .getSingleResult();

            System.out.println("Ha participado en " + count + " conferencias");
        } catch (Exception e) {
            System.out.println("Error en consulta 5: " + e.getMessage());
        }
    }

    // f) Dni, nombre y apellidos de los investigadores que trabajan en el proyecto
    // 4.
    public void consultaJPQL6() {
        System.out.println("\n6. Investigadores que trabajan en el 'Proyecto 4':");
        try {
            String jpql = "SELECT i.dni, i.nombreCompleto " +
                    "FROM investigador i " +
                    "JOIN i.proyecto p " +
                    "WHERE p.nombre = :nombreProyecto";

            List<Object[]> resultados = em.createQuery(jpql, Object[].class)
                    .setParameter("nombreProyecto", "Proyecto 4")
                    .getResultList();

            if (resultados.isEmpty()) {
                System.out.println("No hay investigadores en este proyecto");
            } else {
                for (Object[] row : resultados) {
                    String dni = (String) row[0];
                    String nombre = (String) row[1];
                    System.out.println(" - DNI: " + dni + ", Nombre: " + nombre);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en consulta 6: " + e.getMessage());
        }
    }

    // g) Toda la informacion sobre los proyectos en los que trabajan los
    // investigadores que participaron en la conferencia 5
    public void consultaJPQL7() {
        System.out.println("\n7. Proyectos de investigadores que participaron en 'Conferencia 2':");
        try {
            String jpql = "SELECT DISTINCT p " +
                    "FROM proyecto p " +
                    "JOIN p.investigadores i " +
                    "JOIN i.investigadorConferencias ic " +
                    "JOIN ic.conferencia c " +
                    "WHERE c.nombre = 'Conferencia 2'";

            List<proyecto> resultados = em.createQuery(jpql, proyecto.class).getResultList();

            if (resultados.isEmpty()) {
                System.out.println("   No hay proyectos relacionados con esta conferencia");
            } else {
                for (proyecto p : resultados) {
                    System.out.println("   - Proyecto: " + p.getNombre());
                    System.out.println("     Fecha inicio: " + p.getFechaInicio());
                }
            }
        } catch (Exception e) {
            System.out.println("Error en consulta 7: " + e.getMessage());
        }
    }

    // h) La misma informacion que el anterior, pero para una conferencia
    // determinada.
    public void consultaJPQL8() {
        System.out.println("\n8. Proyectos de investigadores que participaron en una conferencia especifica:");
        try {
            String nombreConferencia = "Conferencia 1";

            String jpql = "SELECT DISTINCT p " +
                    "FROM proyecto p " +
                    "JOIN p.investigadores i " +
                    "JOIN i.investigadorConferencias ic " +
                    "JOIN ic.conferencia c " +
                    "WHERE c.nombre = :nombreConf";

            List<proyecto> resultados = em.createQuery(jpql, proyecto.class)
                    .setParameter("nombreConf", nombreConferencia)
                    .getResultList();

            System.out.println("   Para la conferencia: " + nombreConferencia);
            if (resultados.isEmpty()) {
                System.out.println("   No hay proyectos relacionados con esta conferencia");
            } else {
                System.out.println("   Proyectos encontrados: " + resultados.size());
                for (proyecto p : resultados) {
                    System.out.println("   - " + p.getNombre());
                }
            }
        } catch (Exception e) {
            System.out.println("Error en consulta 8: " + e.getMessage());
        }
    }

    // i) El dni de los investigadores que trabajen en un proyecto cuya fecha de
    // inicio sea menor a una fecha dada.
    public void consultaJPQL9() {
        System.out.println("\n9. Investigadores en proyectos con fecha de inicio anterior a 2020-08-01:");
        try {
            Date fechaLimite = new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-01");

            String jpql = "SELECT DISTINCT i.dni " +
                    "FROM investigador i " +
                    "JOIN i.proyecto p " +
                    "WHERE p.fechaInicio < :fechaLimite";

            List<String> resultados = em.createQuery(jpql, String.class)
                    .setParameter("fechaLimite", fechaLimite)
                    .getResultList();

            if (resultados.isEmpty()) {
                System.out.println("   No hay investigadores en proyectos anteriores a esa fecha");
            } else {
                System.out.println("   DNIs encontrados: " + resultados.size());
                for (String dni : resultados) {
                    System.out.println("   - " + dni);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en consulta 9: " + e.getMessage());
        }
    }

    // j) Toda la informacion sobre las conferencias en las que haya participado un
    // investigador con un apellido concreto.
    public void consultaJPQL10() {
        System.out.println("\n10. Conferencias en las que participaron investigadores con apellido 'Perez':");
        try {
            String jpql = "SELECT DISTINCT c " +
                    "FROM conferencia c " +
                    "JOIN investigador_conferencia ic ON ic.conferencia = c " +
                    "JOIN ic.investigador i " +
                    "WHERE i.nombreCompleto LIKE '%Perez%'";

            List<conferencia> resultados = em.createQuery(jpql, conferencia.class).getResultList();

            if (resultados.isEmpty()) {
                System.out.println("   No hay conferencias para investigadores con ese apellido");
            } else {
                System.out.println("   Conferencias encontradas: " + resultados.size());
                for (conferencia c : resultados) {
                    System.out.println("   - " + c.getNombre() +
                            " (Lugar: " + c.getLugar() +
                            ", Horas: " + c.getNumeroHoras() +
                            ", Fecha: " + c.getFechaHoraInicio() + ")");
                }
            }
        } catch (Exception e) {
            System.out.println("Error en consulta 10: " + e.getMessage());
        }
    }

    // Metodo para ejecutar todas las consultas JPQL
    public void ejecutarTodasConsultas() {
        System.out.println("\n EJERCICIO 3 - CONSULTAS JPQL");
        consultaJPQL1();
        consultaJPQL2();
        consultaJPQL3();
        consultaJPQL4();
        consultaJPQL5();
        consultaJPQL6();
        consultaJPQL7();
        consultaJPQL8();
        consultaJPQL9();
        consultaJPQL10();
        System.out.println("\n EJERCICIO 3 TERMINADO");
    }
}