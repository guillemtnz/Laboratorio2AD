/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio2ad;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Guille
 */
public class ParserDOM {
    
    public static void DOM(){
        
        try{
            
            // Se instancia la factoría y el constructor
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parseo el archivo cargándolo en memoria por completo
            Document doc = builder.parse(new File("imperio.xml"));
            
            //Normalizo la estructura del árbol de nodos
            doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            
            //Se obtiene la lista de todos los nodos nave
            NodeList listaNaves = doc.getElementsByTagName("nave");
            
            for (int i = 0; i < listaNaves.getLength(); i++) {
                Node nodo = listaNaves.item(i);
                
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    
                    // Extraemos un atributo
                    String id = elemento.getAttribute("id");
                    
                    // Extraemos los elementos hijos de texto
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    String piloto = elemento.getElementsByTagName("piloto").item(0).getTextContent();
                    
                    System.out.println("ID: " + id + " | Nave: " + nombre + " | Piloto: " + piloto);
                }
            }
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            
            
        }
        
    }
    
}
