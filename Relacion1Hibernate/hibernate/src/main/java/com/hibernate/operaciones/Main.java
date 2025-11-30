package com.hibernate.operaciones;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.hibernate.entidades.Libro;
import com.hibernate.entidades.Prestamo;
import com.hibernate.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");
        // APARTADO B
        // libros
        Libro libro1 = new Libro(1, "Miguel", "Don Quijote de la Mancha", "Prestado", 863);
        Libro libro2 = new Libro(2, "Federico", "Romancero gitano", "Disponible", 214);
        Libro libro3 = new Libro(3, "Rosalía", "Cantares gallegos", "Disponible", 302);
        Libro libro4 = new Libro(4, "Benito", "Fortunata y Jacinta", "En reparación", 1024);
        Libro libro5 = new Libro(5, "Camilo", "La familia de Pascual Duarte", "Disponible", 256);

        // usuarios
        Usuario usuario1 = new Usuario(1, "Javier", "Moreno", "Santos", "Granada", 3.4, LocalDate.of(2021, 5, 10));
        Usuario usuario2 = new Usuario(2, "Lucía", "Ramírez", "Torres", "Zaragoza", 2.1, LocalDate.of(2019, 8, 25));
        Usuario usuario3 = new Usuario(3, "Andrés", "Gómez", "Pérez", "Málaga", 4.3, LocalDate.of(2022, 2, 14));
        Usuario usuario4 = new Usuario(4, "Sofía", "Martín", "Castillo", "Santander", 1.9, LocalDate.of(2020, 12, 3));
        Usuario usuario5 = new Usuario(5, "Hugo", "Navarro", "Iglesias", "Alicante", 2.7, LocalDate.of(2023, 7, 19));

        // prestamos
        Prestamo prestamo1 = new Prestamo(1, 3, LocalDateTime.now().minusDays(22), LocalDateTime.now().minusDays(10));
        Prestamo prestamo2 = new Prestamo(2, 5, LocalDateTime.now().minusDays(7), LocalDateTime.now().minusDays(2));
        Prestamo prestamo3 = new Prestamo(3, 1, LocalDateTime.now().minusDays(18), LocalDateTime.now().minusDays(5));
        Prestamo prestamo4 = new Prestamo(4, 4, LocalDateTime.now().minusDays(50), null);
        Prestamo prestamo5 = new Prestamo(5, 2, LocalDateTime.now().minusDays(12), LocalDateTime.now().minusDays(3));
        Prestamo prestamo6 = new Prestamo(6, 5, LocalDateTime.now().minusDays(30), LocalDateTime.now().minusDays(20));
        Prestamo prestamo7 = new Prestamo(7, 1, LocalDateTime.now().minusDays(25), null);
        Prestamo prestamo8 = new Prestamo(8, 4, LocalDateTime.now().minusDays(40), LocalDateTime.now().minusDays(28));
        Prestamo prestamo9 = new Prestamo(9, 2, LocalDateTime.now().minusDays(60), LocalDateTime.now().minusDays(45));
        Prestamo prestamo10 = new Prestamo(10, 3, LocalDateTime.now().minusDays(5), LocalDateTime.now().minusDays(1));

        agregarLibro(emf.createEntityManager(), libro1);
        agregarLibro(emf.createEntityManager(), libro2);
        agregarLibro(emf.createEntityManager(), libro3);
        agregarLibro(emf.createEntityManager(), libro4);
        agregarLibro(emf.createEntityManager(), libro5);

        agregarUsuario(emf.createEntityManager(), usuario1);
        agregarUsuario(emf.createEntityManager(), usuario2);
        agregarUsuario(emf.createEntityManager(), usuario3);
        agregarUsuario(emf.createEntityManager(), usuario4);
        agregarUsuario(emf.createEntityManager(), usuario5);

        agregarPrestamo(emf.createEntityManager(), prestamo1);
        agregarPrestamo(emf.createEntityManager(), prestamo2);
        agregarPrestamo(emf.createEntityManager(), prestamo3);
        agregarPrestamo(emf.createEntityManager(), prestamo4);
        agregarPrestamo(emf.createEntityManager(), prestamo5);
        agregarPrestamo(emf.createEntityManager(), prestamo6);
        agregarPrestamo(emf.createEntityManager(), prestamo7);
        agregarPrestamo(emf.createEntityManager(), prestamo8);
        agregarPrestamo(emf.createEntityManager(), prestamo9);
        agregarPrestamo(emf.createEntityManager(), prestamo10);

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        // APARTADO C
        Libro libroEstado = em.find(Libro.class, 1);
        libroEstado.setEstado("Prestado");

        // APARTADO D
        Usuario usuarioCateg = em.find(Usuario.class, 3);
        usuarioCateg.setCategoria(usuarioCateg.getCategoria() * 1.25);

        // APARTADO E
        Prestamo fp = em.find(Prestamo.class, 1);
        fp.setFechaFin(null);

        // APARTADO F
        em.remove(em.find(Usuario.class, 5));
        for (int i = 1; i <= 10; i++) {
            Prestamo prestamo = em.find(Prestamo.class, i);
            if (prestamo.getIdUsuario() == 5) {
                em.remove(prestamo);
            }
        }

        // APARTADO G
        for (int i = 1; i <= 10; i++) {
            Prestamo prestamoG = em.find(Prestamo.class, i);
            if (prestamoG == null) {
                continue;
            } else if (prestamoG.getIdLibro() == 2) {
                em.remove(prestamoG);
            }
        }
        et.commit();
        em.close();
    }

    public static void agregarLibro(EntityManager em, Libro libro) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(libro);
        et.commit();
        em.close();
    }

    public static void agregarUsuario(EntityManager em, Usuario usuario) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(usuario);
        et.commit();
        em.close();
    }

    public static void agregarPrestamo(EntityManager em, Prestamo prestamo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestamo);
        et.commit();
        em.close();
    }
}