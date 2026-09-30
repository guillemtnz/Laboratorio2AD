/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio2ad;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;

/**
 *
 * @author Guille
 */
public class ParserSAX {
    
    public static void SAX() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Definimos el manejador de eventos en línea (o en una clase interna)
            DefaultHandler manejador = new DefaultHandler() {
                private boolean esNombre = false;

                // Evento: Se encuentra una etiqueta de apertura
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("nave")) {
                        // Extraemos el atributo "clase" y lo imprimimos sin salto de línea
                        String clase = attributes.getValue("clase");
                        System.out.print("Clase: " + clase);
                    } else if (qName.equalsIgnoreCase("nombre")) {
                        esNombre = true;
                    }
                }

                // Evento: Se procesa el texto plano dentro de una etiqueta
                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (esNombre) {
                        // Imprimimos el nombre con salto de línea (println) para terminar la fila
                        System.out.println(" | Nombre: " + new String(ch, start, length));
                        esNombre = false;
                    }
                }

                // Evento: Se encuentra una etiqueta de cierre
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // Control de fin de bloques si fuera necesario
                }
            };

            // Lanzamos el análisis secuencial del archivo
            saxParser.parse(new File("imperio.xml"), manejador);

        } catch (Exception e) {
            System.err.println("Error al parsear con SAX: " + e.getMessage());
        }
    }
    
}
