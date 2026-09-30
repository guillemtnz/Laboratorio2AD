/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio2ad;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.io.Serializable;


@XmlRootElement(name = "personaje")
@XmlType(propOrder = {"nombre", "rango"})
public class Personaje implements Serializable {

    private String nombre;
    private String rango;

    public Personaje() {
    }

    public Personaje(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }


    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @XmlElement(name = "rango")
    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String toString() {
        return "Personaje: " + nombre + " | Rango: (" + rango + ")";
    }
}