/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author marce
 */
public class Sesion17Test {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    //private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
       // System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        //System.setErr(originalErr);
    }
    
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testNombreTextField() {
        System.out.println("Probando campo de texto nombre");
        AgregarEmpleadoFrame frame;
        JTextField nombresText;
                
        frame = new AgregarEmpleadoFrame();
        frame.setVisible(Boolean.TRUE);
        
        nombresText = (JTextField)TestUtils.getChildNamed(frame, "nombre");
        
        assertNotNull("No puede acceder al JTextField Nombres", nombresText);
        
        nombresText.setText("Martin");
        
        assertEquals("Martin", nombresText.getText());
        
    }
    
    @Test
    public void testApellidoTextField() {
        System.out.println("Probando campo de texto appellido");
        AgregarEmpleadoFrame frame;
        JTextField texto;
                
        frame = new AgregarEmpleadoFrame();
        frame.setVisible(Boolean.TRUE);
        
        texto = (JTextField)TestUtils.getChildNamed(frame, "apellido");
        
        assertNotNull("No puede acceder al JTextField Apellido", texto);
        
        texto.setText("Martinez");
        
        assertEquals("Martinez", texto.getText());
        
    }
    
    @Test
    public void testCorreoTextField() {
        System.out.println("Probando campo de texto correo");
        AgregarEmpleadoFrame frame;
        JTextField texto;
                
        frame = new AgregarEmpleadoFrame();
        frame.setVisible(Boolean.TRUE);
        
        texto = (JTextField)TestUtils.getChildNamed(frame, "correo");
        
        assertNotNull("No puede acceder al JTextField Correo", texto);
        
        texto.setText("m@m.com");
        
        assertEquals("m@m.com", texto.getText());
        
    }
    
    @Test
    public void testCelularTextField() {
        System.out.println("Probando campo de texto celular");
        AgregarEmpleadoFrame frame;
        JTextField texto;
                
        frame = new AgregarEmpleadoFrame();
        frame.setVisible(Boolean.TRUE);
        
        texto = (JTextField)TestUtils.getChildNamed(frame, "celular");
        
        assertNotNull("No puede acceder al JTextField Celular", texto);
        
        texto.setText("3103245");
        
        assertEquals("3103245", texto.getText());
        
    }
    
    @Test
    public void testSalarioTextField() {
        System.out.println("Probando campo de texto salario");
        AgregarEmpleadoFrame frame;
        JTextField texto;
                
        frame = new AgregarEmpleadoFrame();
        frame.setVisible(Boolean.TRUE);
        
        texto = (JTextField)TestUtils.getChildNamed(frame, "salario");
        
        assertNotNull("No puede acceder al JTextField salario", texto);
        
        texto.setText("1000000");
        
        assertEquals("1000000", texto.getText());
        
    }
    
    @Test
    public void testCargoTextField() {
        System.out.println("Probando campo de texto cargo");
        AgregarEmpleadoFrame frame;
        JTextField texto;
                
        frame = new AgregarEmpleadoFrame();
        frame.setVisible(Boolean.TRUE);
        
        texto = (JTextField)TestUtils.getChildNamed(frame, "cargo");
        
        assertNotNull("No puede acceder al JTextField cargo", texto);
        
        texto.setText("Director");
        
        assertEquals("Director", texto.getText());
        
    }
    
    @Test
    public void testBotonAgregar() {
        //System.out.println("Probando boton Agregar");
        AgregarEmpleadoFrame frame;
        JButton boton;
                
        frame = new AgregarEmpleadoFrame();
        frame.setVisible(Boolean.TRUE);
        
        JTextField nombre;
        JTextField apellido;
        JTextField salario;
               
        nombre = (JTextField)TestUtils.getChildNamed(frame, "nombre");
        apellido = (JTextField)TestUtils.getChildNamed(frame, "apellido");
        salario = (JTextField)TestUtils.getChildNamed(frame, "salario");
        
        nombre.setText("Martin");
        apellido.setText("Perez");
        salario.setText("10000000");
        
        boton = (JButton)TestUtils.getChildNamed(frame, "agregar");
        
        assertNotNull("No puede acceder al JButton agregar", boton);

        ActionEvent event;
        long when;

        when  = System.currentTimeMillis();
        event = new ActionEvent(boton, ActionEvent.ACTION_PERFORMED, "Prueba", when, 0);

        for (ActionListener listener : boton.getActionListeners()) {
            listener.actionPerformed(event);
        }
        
        assertEquals("Empleado creado", outContent.toString().trim());
        
    }
}
