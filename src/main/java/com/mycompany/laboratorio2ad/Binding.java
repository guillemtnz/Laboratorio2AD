/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio2ad;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 *
 * @author Guille
 */
public class Binding {
    
    public static void hacerBinding(){
        File fichero = new File("rebelde.xml");
        
        // Instancia de Luke
        Personaje luke = new Personaje("Luke Skywalker", "Comandante / Caballero Jedi");

        try {
            // Instanciamos el contexto pasándole nuestra clase anotada
            JAXBContext contexto = JAXBContext.newInstance(Personaje.class);
            Marshaller marshaller = contexto.createMarshaller();

            // Configuración para que el XML de salida tenga tabulaciones y saltos de línea legibles
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Vuelco el objeto  al fichero
            marshaller.marshal(luke, fichero);
            

            //Se muestra por consola
            System.out.println("--- Contenido generado ---");
            marshaller.marshal(luke, System.out);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        if (fichero.exists()) {
            try {
                JAXBContext contexto = JAXBContext.newInstance(Personaje.class);
                Unmarshaller unmarshaller = contexto.createUnmarshaller();

                // Leemos el archivo y casteamos al tipo Personaje
                Personaje personajeRecuperado = (Personaje) unmarshaller.unmarshal(fichero);
                
                System.out.println("Objeto Java recuperado desde el XML con éxito:");
                // Al imprimirlo, se usa automáticamente el método toString() que definimos en la clase
                System.out.println(personajeRecuperado);

            } catch (Exception e) {
                System.err.println("Error durante el Unmarshalling: " + e.getMessage());
            }
        }
    }
    
}
