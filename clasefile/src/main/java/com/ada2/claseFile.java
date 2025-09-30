package com.ada2;

import java.io.*;

public class claseFile {

    public static void main(String[] args) {

        String rutaPrincipal = System.getProperty("user.home") + "/Desktop";
        crearEstructura(rutaPrincipal);
        //Ej2
        File dirRaiz = new File(rutaPrincipal, "d");
        System.out.println("Lista:");
        listarDirectorio(dirRaiz, "");
        //Ej3
        System.out.println("Lista modificada:");
        listarModificar(rutaPrincipal + "/d");
        //Ej4
        System.out.println("Archivos del directorio d1:");
        listarPorExtension(rutaPrincipal + "/d/d1", ".txt");
        //Ej5
        System.out.println("Borrando los archivos del directorio d1:");
        eliminarArchivos(rutaPrincipal + "/d/d1");
    }

    public static void crearEstructura(String rutaPrincipal) {
        try {
            File d = new File(rutaPrincipal, "d");
            d.mkdir();

            File d1 = new File(d, "d1");

            d1.mkdir();

            new File(d1, "f11.txt").createNewFile();
            new File(d1, "f12.txt").createNewFile();

            File d2 = new File(d, "d2");

            d2.mkdir();

            File d21 = new File(d2, "d21");

            d21.mkdir();

            new File(d2, "f21.txt").createNewFile();
            File d22 = new File(d2, "d22");

            d22.mkdir();

            new File(d22, "f222.txt").createNewFile();

            File d3 = new File(d, "d3");

            d3.mkdir();

            File d31 = new File(d3, "d31");
            
            d31.mkdir();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listarDirectorio(File dir, String prefijo) {
        if (dir.isDirectory()) {
            System.out.println(prefijo + dir.getName());
            File[] dirHijos = dir.listFiles();
            if (dirHijos != null) {
                for (File file : dirHijos) {
                    listarDirectorio(file, prefijo + "    ");
                }
            }
        } else {
            System.out.println(prefijo + dir.getName());
        }
    }

    public static void listarModificar(String ruta) {
        File dirRaiz = new File(ruta);
        if (dirRaiz.exists()) {
            listarDirectorio(dirRaiz, "");
        } else {
            System.out.println("No existe el dir");
        }
    }

    public static void listarPorExtension(String ruta, String extension) {
        System.out.println("Directorio: " + ruta);
        File dirRaiz = new File(ruta);
        File[] dirHijos = dirRaiz.listFiles();

        if (dirHijos != null) {
            for (File file : dirHijos) {
                if (file.getName().endsWith(extension)) {
                    System.out.println(file.getName());
                }
            }
        }
    }

    public static void eliminarArchivos(String ruta) {
        File dirRaiz = new File(ruta);
        File[] dirHijos = dirRaiz.listFiles();

        if (dirHijos != null) {
            for (File file : dirHijos) {
                if (file.getName().endsWith(".txt")) {
                    file.delete();
                }
            }
        }
        System.out.println("Los archivos se han eliminado");
    }
}