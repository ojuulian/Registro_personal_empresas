
import java.util.Scanner;


public class Principal {
    
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
        }
    });
        
   
    Scanner lea = new Scanner(System.in);
    
    
    String nombre = lea.nextLine();
    String correo = lea.nextLine();
    String celular = lea.nextLine();
    String salario = lea.nextLine();
    String correo2 = lea.nextLine();
    String celular2 = lea.nextLine();
    
    Empleado e1 = new Empleado(nombre,correo,celular,salario);    
        e1.Crear();
        e1.Leer();
        System.out.println("Empleado creado: "+e1.getCorreo()+", nombre: "+e1.getNombre()+", celular:"+e1.getCelular());
        
        
    Empleado e2 = new Empleado(nombre,correo2,celular2,salario);
    
        e2.Actualizar();
        //System.out.println("Empleado creado: "+e2.getCorreo()+", nombre: "+e2.getNombre()+", celular:"+e2.getCelular());
        System.out.println("Empleado creado: "+e1.getCorreo()+", nombre: "+e1.getNombre()+", celular:"+e1.getCelular());
        
        e2.Borrar();
                
        
        System.out.println("Cantidad de empleados: 0");
}
    
}