/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OSCAR
 */
public class EmpleadoTest {
    
    
 
    //#######################################################################################################
    /**
     * Test of Crear method, of class Empleado.
     */
    @Test
    public void testCrear() {
        
        
        System.out.println("Probando el crear un query");
        Empleado e = new Empleado("Miguel","Jimenez","m@m","320",false,"100000","Profesor");
        String rta = "Empleado creado";
        e.Crear();
        assertEquals(rta,e.Crear(),0);
    }

    /*
    @Test
    public void testLeer() {
               
        System.out.println("Probando el Leer un query");
        Empleado e2 = new Empleado("Miguel","Jimenez","m@m","320",false,"100000","Profesor");
        String rtaleer = "Empleado leido";
        e2.Leer();
        assertEquals(rtaleer,e2.Leer(),0);
    }

 
     */
    @Test
    public void testActualizar() {
               
        System.out.println("Probando el Actualizar un query");
        Empleado e3= new Empleado("Miguel","Jimenez","m@m","320",false,"100000","Profesor");
        String rtaActualiza = "Empleado actualizado";
        e3.Actualizar();
        assertEquals(rtaActualiza,e3.Actualizar(),0);
    }

    /**
     * Test of Borrar method, of class Empleado.
     */
    @Test
    public void testBorrar() {
       
        
        System.out.println("Probando el Eliminar un query");
        Empleado e3= new Empleado("Miguel","Jimenez","m@m","320",false,"100000","Profesor");
        String rtaActualiza = "Empleado actualizado";
        e3.Actualizar();
        assertEquals(rtaActualiza,e3.Actualizar(),0);
        
    }
    
}
