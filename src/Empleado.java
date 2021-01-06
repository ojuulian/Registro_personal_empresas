
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Empleado {
    
    private final AtomicInteger count = new AtomicInteger(0);
    private long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String celular;
    private Boolean esProveedor;
    private String salario;
    private String cargo;

    //Constuctior pedido por reto semanal
    public Empleado(String nombre, String correo, String celular, String salario) {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.salario = salario;
    }
    
    public Empleado(long id, String nombre, String apellido, String correo, String celular, Boolean esProveedor, String salario, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.esProveedor = esProveedor;
        this.salario = salario;
        this.cargo = cargo;
    }
    
    public Empleado(String nombre, String apellido, String correo, String celular, Boolean esProveedor, String salario, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.esProveedor = esProveedor;
        this.salario = salario;
        this.cargo = cargo;
    }
    
    //Constructor diseñado solo para eliminar registros en la base a partir del frame Nueva 
     public Empleado(long id) {
        this.id=id;
    }
    
    //getter and setter ID
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    //getter and setter Nombre   
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //getter and setter Apellido
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //getter and setter Correo
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    //getter and setter Celular
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    //getter and setter Proveedor
    public Boolean getEsProveedor() {
        return esProveedor;
    }
    public void setEsProveedor(Boolean esProveedor) {
        this.esProveedor = esProveedor;
    }

    //getter and setter Salario
    public String getSalario() {
        return salario;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }

    //getter and setter Cargo
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    //INSERT
    public int Crear(){
        int ultimo = 0;
        try{
            Conexion conexion = new Conexion("mydb.db");
            conexion.conectar();
            
            Statement stmt = conexion.getConexion().createStatement();
            String sql = "INSERT INTO empleados (nombre,apellido,correo,celular,esProveedor, salario, cargo) "
                        + "VALUES ('"+this.nombre+"','"+this.apellido+"','"+this.correo
                        +"','"+this.celular+"','"+this.esProveedor+"','"+this.salario+"','"+this.cargo+"')";
           
            stmt.executeUpdate(sql);
            stmt.close();
            conexion.cerrarConexion();
                        
        }catch(SQLException e){
            //System.out.println("Error en la inserción de datos: " + e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return ultimo;
    }
    
    //SELECT
     public static ArrayList<Empleado> Leer(){
        ArrayList<Empleado> empleados = new ArrayList();
        
        try{
             Conexion conexion = new Conexion("mydb.db");
            conexion.conectar();
            
            Statement stmt = conexion.getConexion().createStatement();
            String sql = "SELECT * FROM empleados";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                
                long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String celular = rs.getString("celular");
                Boolean esProveedor = rs.getBoolean("esProveedor");
                String salario = rs.getString("salario");
                String cargo = rs.getString("cargo");
                
                empleados.add(new Empleado(id, nombre,apellido,correo, celular, esProveedor, salario, cargo));
                //empleados.add(new Empleado((long)rs.getInt("id"),  rs.getString("nombre")));
            }
            rs.close();
            conexion.cerrarConexion();
          
        }catch(SQLException e){
            //System.out.println("Error en la consulta de datos: " + e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
        return empleados;
    }
    
     //UPDATE
     public int Actualizar(){
         int ultimo = 0;
         try{
            Conexion conexion = new Conexion("mydb.db");
            conexion.conectar();
                 
            Statement stmt2 = conexion.getConexion().createStatement();
            String sql = "UPDATE Empleados SET Nombre='" +this.nombre+ "',Apellido='" +this.apellido+ "',Correo='" +this.correo+
                        "',Celular='" +this.celular+"',esProveedor='" +this.esProveedor+"',Salario='" +this.salario+ "',Cargo='"
                        +this.cargo+ "' where id="+this.id+";";
            
            stmt2.execute(sql);
            stmt2.close();
            conexion.cerrarConexion();
        }catch(SQLException e){
            //System.out.println("Error en la actualización de datos: " + e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
        return ultimo;
    }
     
     //DELETE
     public int Borrar(){
        int ultimo = 0;
        try{
            Conexion conexion = new Conexion("mydb.db");
            conexion.conectar();
            
            Statement stmt = conexion.getConexion().createStatement();
            String sql = "DELETE FROM Empleados WHERE id="+this.id+";";
            stmt.execute(sql);
            stmt.close();
        }catch(Exception ex){
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimo;
     }

     
     
     
     
   
     
    
}


