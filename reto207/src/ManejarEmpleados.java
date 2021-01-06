
import java.util.concurrent.atomic.AtomicInteger;

public class ManejarEmpleados{
    /*long id, String nombre, String apellido, String correo, String celular, 
        Boolean esProveedor, int salario, String cargo*/
     
    public static Empleado [] obtenerEmpleados(){
        AtomicInteger ai = new AtomicInteger(0);
        Empleado e [] = new Empleado[5];
        e[0] = new Empleado(ai.incrementAndGet(),"Miguel","Jimenez","m@m","320",false,"100000","Profesor");
        e[1] = new Empleado(ai.incrementAndGet(),"Juan","Perez","jm@m","310",true,"1000000","Profesor Auxiliar");
        e[2] = new Empleado(ai.incrementAndGet(),"Pedro","Gonzalez","mk@m","300",false,"200000","Ayudante");
        e[3] = new Empleado(ai.incrementAndGet(),"Luis","Guerra","nml@m","315",true,"2000000","Gerente");
        e[4] = new Empleado(ai.incrementAndGet(),"Jose","Ortiz","jo1@m","323",false,"300000","SubGerente");
        return e;
    }
}
