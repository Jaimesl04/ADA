package com.ada.flujo;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {

        try (FileInputStream origen = new FileInputStream("/home/alumnadotarde/Descargas/imagenes/some-wallpapers-v0-7k375fl2xyge1.png");
                FileOutputStream destino = new FileOutputStream("/home/alumnadotarde/Descargas/imagen destino/copia.png")) {

            try {
                // bucle infinito
                int b;
                for (;;) {
                    b=(int)origen.read();
                    destino.write(b);



                    
                }
            } catch (EOFException e) {


            }

            // Segundo método
            // destino.write(origen.readAllBytes());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}