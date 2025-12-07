package com.hibernate2.test;

import com.hibernate2.entidades.conferencia;
import com.hibernate2.entidades.investigador;
import com.hibernate2.entidades.investigador_conferencia;
import com.hibernate2.entidades.proyecto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
    private static EntityManager em;

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Empresa");
        em = emf.createEntityManager();
        System.out.println("EJERCICIO 2");

        // APARTADO B: INSERTAR DATOS INICIALES
        System.out.println("\n 1. INSERTANDO DATOS INICIALES");
        insertarDatosIniciales();

        // APARTADO C: CONSULTAS
        System.out.println("\n 2. CONSULTAS");
        ejecutarConsultasDeVisualizacion();

        // APARTADO D: OPERACIONES DE ACTUALIZACION
        System.out.println("\n 3. OPERACIONES DE ACTUALIZACION");
        ejecutarOperacionesDeActualizacion();

        // APARTADO E: ELIMINAR
        /*
         * System.out.println("\n 4. OPERACIONES DE ELIMINACION");
         * ejecutarOperacionesDeEliminacion();
         */

        em.close();
        emf.close();

        System.out.println("\n PROGRAMA FINALIZADO");
    }

    // METODOS AUXILIARES PARA CREAR OBJETOS

    private static investigador crearNuevoInvestigador(String dni, String nombreCompleto, String direccion,
            String telefono, String localidad) {
        investigador nuevoInvestigador = new investigador();
        nuevoInvestigador.setDni(dni);
        nuevoInvestigador.setNombreCompleto(nombreCompleto);
        nuevoInvestigador.setDireccion(direccion);
        nuevoInvestigador.setTelefono(telefono);
        nuevoInvestigador.setLocalidad(localidad);
        return nuevoInvestigador;
    }

    private static conferencia crearNuevaConferencia(String nombreConferencia, String fecha, String lugar, double horas)
            throws Exception {
        conferencia nuevaConferencia = new conferencia();
        nuevaConferencia.setNombre(nombreConferencia);
        nuevaConferencia
                .setFechaHoraInicio(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(fecha).getTime()));
        nuevaConferencia.setLugar(lugar);
        nuevaConferencia.setNumeroHoras(horas);
        return nuevaConferencia;
    }

    private static proyecto crearNuevoProyecto(String nombreProyecto, String fechaInicio) throws Exception {
        proyecto nuevoProyecto = new proyecto();
        nuevoProyecto.setNombre(nombreProyecto);
        nuevoProyecto
                .setFechaInicio(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio).getTime()));
        return nuevoProyecto;
    }

    private static investigador_conferencia crearNuevaAsistenciaConferencia(investigador investigador,
            conferencia conferencia) {
        investigador_conferencia nuevaAsistencia = new investigador_conferencia(investigador, conferencia);
        return nuevaAsistencia;
    }

    // APARTADO b): INSERTAR DATOS INICIALES

    private static void insertarDatosIniciales() throws Exception {
        EntityTransaction transaccion = em.getTransaction();
        transaccion.begin();

        try {
            System.out.println("Creando proyectos...");

            proyecto proyecto1 = crearNuevoProyecto("Proyecto 1", "2020-05-05");
            proyecto proyecto2 = crearNuevoProyecto("Proyecto 2", "2020-06-12");
            proyecto proyecto3 = crearNuevoProyecto("Proyecto 3", "2020-08-15");
            proyecto proyecto4 = crearNuevoProyecto("Proyecto 4", "2020-11-01");
            proyecto proyecto5 = crearNuevoProyecto("Proyecto 5", "2020-12-12");

            em.persist(proyecto1);
            em.persist(proyecto2);
            em.persist(proyecto3);
            em.persist(proyecto4);
            em.persist(proyecto5);

            System.out.println("Creando investigadores...");

            investigador investigador1 = crearNuevoInvestigador("30487452M", "Juan Pérez Martínez", "C./ Desengaño 21",
                    "623423523", "Cádiz");
            investigador investigador2 = crearNuevoInvestigador("45768434R", "Luisa Puertas Soto", "C./ Falsa 123",
                    "693543252", "Cádiz");
            investigador investigador3 = crearNuevoInvestigador("45642323B", "María Ruiz Sánchez", "C./ Almiel 12",
                    "623234523", "Cádiz");
            investigador investigador4 = crearNuevoInvestigador("67534312A", "Pablo Fernández Feria",
                    "Avd. Inventada 15", "613442323", "Cádiz");
            investigador investigador5 = crearNuevoInvestigador("65342316R", "Sofía Luque Conde", "C/ La Virtud 1",
                    "664123623", "Cádiz");
            investigador investigador6 = crearNuevoInvestigador("67323452B", "José López", "C./ Almiel 15", "723234523",
                    "Cádiz");
            investigador investigador7 = crearNuevoInvestigador("78953321A", "Andrés Fernán Noria", "Avd. Inventada 11",
                    "713442323", "Cádiz");
            investigador investigador8 = crearNuevoInvestigador("98634571R", "Sofía Martín Luz", "C/ La Virtud 4",
                    "764123623", "Cádiz");

            System.out.println("Asignando proyectos a los investigadores...");

            investigador1.setProyecto(proyecto1);
            investigador5.setProyecto(proyecto1);

            investigador2.setProyecto(proyecto2);
            investigador4.setProyecto(proyecto2);

            investigador3.setProyecto(proyecto3);
            investigador7.setProyecto(proyecto3);

            investigador6.setProyecto(proyecto4);
            investigador8.setProyecto(proyecto4);

            em.persist(investigador1);
            em.persist(investigador2);
            em.persist(investigador3);
            em.persist(investigador4);
            em.persist(investigador5);
            em.persist(investigador6);
            em.persist(investigador7);
            em.persist(investigador8);

            System.out.println("Creando conferencias...");

            conferencia conferencia1 = crearNuevaConferencia("Conferencia 1", "2020-11-02", "San Fernando", 2.5);
            conferencia conferencia2 = crearNuevaConferencia("Conferencia 2", "2021-01-12", "Sevilla", 4.0);
            conferencia conferencia3 = crearNuevaConferencia("Conferencia 3", "2021-07-01", "San Fernando", 1.5);
            conferencia conferencia4 = crearNuevaConferencia("Conferencia 4", "2021-11-02", "Berlín", 3.0);

            em.persist(conferencia1);
            em.persist(conferencia2);
            em.persist(conferencia3);
            em.persist(conferencia4);

            System.out.println("Registrando asistencias a conferencias...");

            investigador_conferencia asistencia1 = crearNuevaAsistenciaConferencia(investigador1, conferencia2);
            em.persist(asistencia1);

            investigador_conferencia asistencia2_1 = crearNuevaAsistenciaConferencia(investigador2, conferencia1);
            investigador_conferencia asistencia2_2 = crearNuevaAsistenciaConferencia(investigador2, conferencia3);
            em.persist(asistencia2_1);
            em.persist(asistencia2_2);

            investigador_conferencia asistencia3_1 = crearNuevaAsistenciaConferencia(investigador3, conferencia1);
            investigador_conferencia asistencia3_2 = crearNuevaAsistenciaConferencia(investigador3, conferencia2);
            investigador_conferencia asistencia3_3 = crearNuevaAsistenciaConferencia(investigador3, conferencia3);
            investigador_conferencia asistencia3_4 = crearNuevaAsistenciaConferencia(investigador3, conferencia4);
            em.persist(asistencia3_1);
            em.persist(asistencia3_2);
            em.persist(asistencia3_3);
            em.persist(asistencia3_4);

            investigador_conferencia asistencia4_1 = crearNuevaAsistenciaConferencia(investigador4, conferencia1);
            em.persist(asistencia4_1);

            investigador_conferencia asistencia5_1 = crearNuevaAsistenciaConferencia(investigador5, conferencia1);
            investigador_conferencia asistencia5_2 = crearNuevaAsistenciaConferencia(investigador5, conferencia2);
            investigador_conferencia asistencia5_3 = crearNuevaAsistenciaConferencia(investigador5, conferencia3);
            investigador_conferencia asistencia5_4 = crearNuevaAsistenciaConferencia(investigador5, conferencia4);
            em.persist(asistencia5_1);
            em.persist(asistencia5_2);
            em.persist(asistencia5_3);
            em.persist(asistencia5_4);

            transaccion.commit();
            System.out.println("Datos insertados \n");

        } catch (Exception e) {
            if (transaccion.isActive()) {
                transaccion.rollback();
            }
            System.out.println("Error al insertar datos: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    // PARTE c): CONSULTAS

    private static void ejecutarConsultasDeVisualizacion() {
        try {
            System.out.println("\n  CONSULTA 1: Proyectos en los que trabaja cada investigador:");
            String consultaProyectosPorInvestigador = "SELECT i.nombreCompleto, p.nombre " +
                    "FROM investigador i " +
                    "LEFT JOIN i.proyecto p " +
                    "ORDER BY i.nombreCompleto";

            List<Object[]> resultadosProyectos = em.createQuery(consultaProyectosPorInvestigador, Object[].class)
                    .getResultList();

            if (resultadosProyectos.isEmpty()) {
                System.out.println("No hay datos registrados");
            } else {
                for (Object[] fila : resultadosProyectos) {
                    String nombreInvestigador = (String) fila[0];
                    String nombreProyecto = fila[1] != null ? (String) fila[1] : "Sin proyecto asignado";
                    System.out.println("    - " + nombreInvestigador + " -> " + nombreProyecto);
                }
            }

            System.out.println("\n  CONSULTA 2: Investigadores que trabajan en cada proyecto:");
            String consultaInvestigadoresPorProyecto = "SELECT p.nombre, i.nombreCompleto " +
                    "FROM proyecto p " +
                    "LEFT JOIN p.investigadores i " +
                    "ORDER BY p.nombre, i.nombreCompleto";

            List<Object[]> resultadosInvestigadores = em.createQuery(consultaInvestigadoresPorProyecto, Object[].class)
                    .getResultList();

            if (resultadosInvestigadores.isEmpty()) {
                System.out.println("    No hay datos");
            } else {
                for (Object[] fila : resultadosInvestigadores) {
                    String nombreProyecto = (String) fila[0];
                    String nombreInvestigador = fila[1] != null ? (String) fila[1]
                            : "No tiene investigadores asignados";
                    System.out.println("    - " + nombreProyecto + " -> " + nombreInvestigador);
                }
            }

            System.out.println("\n  CONSULTA 3: Investigadores que han asistido a cada conferencia:");
            String consultaAsistentesPorConferencia = "SELECT c.nombre, i.nombreCompleto " +
                    "FROM investigador_conferencia ic " +
                    "JOIN ic.conferencia c " +
                    "JOIN ic.investigador i " +
                    "ORDER BY c.nombre, i.nombreCompleto";

            List<Object[]> resultadosAsistentes = em.createQuery(consultaAsistentesPorConferencia, Object[].class)
                    .getResultList();

            if (resultadosAsistentes.isEmpty()) {
                System.out.println("    No hay datos registrados");
            } else {
                for (Object[] fila : resultadosAsistentes) {
                    String nombreConferencia = (String) fila[0];
                    String nombreInvestigador = (String) fila[1];
                    System.out.println("    - " + nombreConferencia + " -> " + nombreInvestigador);
                }
            }

            System.out.println("\n  CONSULTA 4: Conferencias en las que ha estado cada investigador:");
            String consultaConferenciasPorInvestigador = "SELECT i.nombreCompleto, c.nombre " +
                    "FROM investigador_conferencia ic " +
                    "JOIN ic.investigador i " +
                    "JOIN ic.conferencia c " +
                    "ORDER BY i.nombreCompleto, c.nombre";

            List<Object[]> resultadosConferencias = em.createQuery(consultaConferenciasPorInvestigador, Object[].class)
                    .getResultList();

            if (resultadosConferencias.isEmpty()) {
                System.out.println("    No hay datos registrados");
            } else {
                for (Object[] fila : resultadosConferencias) {
                    String nombreInvestigador = (String) fila[0];
                    String nombreConferencia = (String) fila[1];
                    System.out.println("    - " + nombreInvestigador + " -> " + nombreConferencia);
                }
            }

        } catch (Exception e) {
            System.out.println("Error en consultas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // PARTE d): OPERACIONES DE ACTUALIZACIÓN

    private static void ejecutarOperacionesDeActualizacion() {
        EntityTransaction transaccion = em.getTransaction();
        transaccion.begin();

        try {
            System.out.println("\n  ACTUALIZACIÓN 1: Investigador 2 ahora solo asiste a Conferencia 2:");

            investigador investigadorLuisa = em.find(investigador.class, "45768434R");
            conferencia conferenciaSevilla = em.find(conferencia.class, "Conferencia 2");

            if (investigadorLuisa != null && conferenciaSevilla != null) {
                Query consultaEliminarAsistencias = em.createQuery(
                        "DELETE FROM investigador_conferencia ic " +
                                "WHERE ic.investigador.dni = :dniInvestigador");
                consultaEliminarAsistencias.setParameter("dniInvestigador", "45768434R");
                int numeroAsistenciasEliminadas = consultaEliminarAsistencias.executeUpdate();
                System.out.println("    Eliminadas " + numeroAsistenciasEliminadas + " asistencias anteriores");

                investigador_conferencia nuevaAsistencia = crearNuevaAsistenciaConferencia(investigadorLuisa,
                        conferenciaSevilla);
                em.persist(nuevaAsistencia);
                System.out.println("    " + investigadorLuisa.getNombreCompleto() + " ahora solo asiste a: "
                        + conferenciaSevilla.getNombre());
            } else {
                System.out.println("    No se ha encontrado el investigador 2 o la conferencia 2");
            }

            System.out.println("\n ACTUALIZACIÓN 2: Actualizando fecha de Conferencia 4 a fecha actual:");
            conferencia conferenciaBerlin = em.find(conferencia.class, "Conferencia 4");

            if (conferenciaBerlin != null) {
                conferenciaBerlin.setFechaHoraInicio(new java.sql.Date(new Date().getTime()));
                em.merge(conferenciaBerlin);
                System.out.println("    " + conferenciaBerlin.getNombre() + " actualizada. Nueva fecha: " + new Date());
            } else {
                System.out.println("    No se ha encontrado la Conferencia 4");
            }

            System.out.println("\n  ACTUALIZACION 3: Todos los investigadores trabajan en Proyecto 3:");

            proyecto proyecto3 = em.find(proyecto.class, "Proyecto 3");

            if (proyecto3 != null) {
                List<investigador> listaCompletaInvestigadores = em
                        .createQuery("SELECT i FROM investigador i", investigador.class).getResultList();
                int investigadoresReasignados = 0;

                for (investigador investigadorActual : listaCompletaInvestigadores) {
                    investigadorActual.setProyecto(proyecto3);
                    em.merge(investigadorActual);
                    investigadoresReasignados++;
                }

                System.out.println("    " + investigadoresReasignados + " investigadores ahora trabajan en: "
                        + proyecto3.getNombre());
            } else {
                System.out.println("    No se ha encontrado el Proyecto 3");
            }

            transaccion.commit();
            System.out.println("\n Todas las actualizaciones realizadas");

        } catch (Exception e) {
            if (transaccion.isActive()) {
                transaccion.rollback();
            }
            System.out.println("Error en las actualizaciones: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // PARTE e): OPERACIONES DE ELIMINACION

    private static void ejecutarOperacionesDeEliminacion() {
        EntityTransaction transaccion = em.getTransaction();
        transaccion.begin();

        try {
            System.out.println("\n  ELIMINACION 1: Eliminando investigador 2:");
            investigador investigadorAEliminar = em.find(investigador.class, "45768434R");
            if (investigadorAEliminar != null) {
                Query consultaEliminarAsistencias = em
                        .createQuery(
                                "DELETE FROM investigador_conferencia ic " +
                                        "WHERE ic.investigador.dni = :dni");
                consultaEliminarAsistencias.setParameter("dni", "45768434R");
                int asistenciasEliminadas = consultaEliminarAsistencias.executeUpdate();
                System.out.println("    Eliminadas " + asistenciasEliminadas + " asistencias");

                em.remove(investigadorAEliminar);
                System.out.println("Investigador 2 eliminado");
            } else {
                System.out.println("Investigador 2 no encontrado");
            }

            System.out.println("\n  ELIMINACIÓN 2: Eliminando proyecto 1:");
            proyecto proyectoAEliminar = em.find(proyecto.class, "Proyecto 1");
            if (proyectoAEliminar != null) {
                List<investigador> investigadoresDelProyecto = em.createQuery(
                        "SELECT i FROM investigador i " +
                                "WHERE i.proyecto.nombre = :nombreProyecto",
                        investigador.class)
                        .setParameter("nombreProyecto", "Proyecto 1")
                        .getResultList();

                for (investigador investigadorActual : investigadoresDelProyecto) {
                    investigadorActual.setProyecto(null);
                    em.merge(investigadorActual);
                }
                System.out.println("Desasociados " + investigadoresDelProyecto.size() + " investigadores");

                em.remove(proyectoAEliminar);
                System.out.println("Proyecto 1 eliminado");
            } else {
                System.out.println("Proyecto 1 no encontrado");
            }

            System.out.println("\n  ELIMINACIÓN 3: Eliminando conferencia 4:");
            conferencia conferenciaAEliminar = em.find(conferencia.class, "Conferencia 4");
            if (conferenciaAEliminar != null) {
                Query consultaEliminarAsistenciasConferencia = em
                        .createQuery(
                                "DELETE FROM investigador_conferencia ic " +
                                        "WHERE ic.conferencia.nombre = :nombre");
                consultaEliminarAsistenciasConferencia.setParameter("nombre", "Conferencia 4");
                int asistenciasEliminadasConferencia = consultaEliminarAsistenciasConferencia.executeUpdate();
                System.out.println("Eliminadas " + asistenciasEliminadasConferencia + " asistencias");

                em.remove(conferenciaAEliminar);
                System.out.println("Conferencia 4 eliminada");
            } else {
                System.out.println("Conferencia 4 no encontrada");
            }

            transaccion.commit();
            System.out.println("\n Todas las eliminaciones realizadas");

        } catch (Exception e) {
            if (transaccion.isActive()) {
                transaccion.rollback();
            }
            System.out.println("Error en eliminaciones: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
