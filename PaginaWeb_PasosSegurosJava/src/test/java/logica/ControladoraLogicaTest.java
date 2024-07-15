package logica;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author kmilo
 */
public class ControladoraLogicaTest {
    
    private ControladoraLogica controladoraLogica;
    private List<Cliente> clientes;
    private List<Usuario> usuarios;
    
    
    @BeforeEach
    public void setUp(){
        controladoraLogica = new ControladoraLogica();
        clientes = new ArrayList<>();
        usuarios = new ArrayList<>();
    }
    
   /* 
   @Test
   public void getClientesTest(){
       
       //Llamaos el metodo que vamos a testear
       List<Cliente> resultadoObtenido = controladoraLogica.getClientes();
       
       Cliente resultadoEsperado = resultadoObtenido.get(0);
       
       Assertions.assertEquals(13, resultadoObtenido.size());
       
       //Verificamos que el cliente se encuentre ne la base de datos
       boolean encontrarCliente = false;
       for(Cliente cliente: resultadoObtenido){
           if(cliente.equals(resultadoEsperado)){
               encontrarCliente = true;
               break;
           }
       }
       
       Assertions.assertTrue(encontrarCliente);
       
   }
    */
   
   /*@Test
   public void crearClienteTest(){
       Cliente cliente = new Cliente();
       cliente.setNombrePersona("Andres");
       cliente.setApellidosPersona("Garcia");
       cliente.setCorreoElectronico("andresgarcia@gmail.com");
       cliente.setPassword("Andres12345");
       
        //Llamaos el metodo que vamos a testear
       controladoraLogica.crearCliente(cliente);
       
       //Se guardan los clientes en una lista
       List<Cliente> resultadoObtenido = controladoraLogica.getClientes();
       
       //Verificamos 
       Assertions.assertEquals("andresgarcia@gmail.com", resultadoObtenido.get(7).getCorreoElectronico());
       
       List<Usuario> resultadoUsuarioObtenido = controladoraLogica.getUsuarios();
       
       Assertions.assertEquals("andresgarcia@gmail.com", resultadoUsuarioObtenido.get(2).getCorreoElectronico());
   }
    */
  /*  
   @Test
   public void getUsuariosTest(){
       //Llamaos el metodo que vamos a testear
       List<Usuario> reultadoObtenido = controladoraLogica.getUsuarios();
       
       Assertions.assertEquals(8, reultadoObtenido.size());
       Assertions.assertEquals("kmilo.150c@gmail.com", reultadoObtenido.get(0).getCorreoElectronico());
       
   }    
    
   */
   @Test
   public void autenticarUsuarioTest(){
       
       //Validamos que las credenciales correctas ingresen correctamente
       boolean resultadoObtenido = controladoraLogica.autenticarUsuario("kmilo.150c@gmail.com", "Camilo.16");
       
       //Se ingresa una contraseña errorea para verificar que de false evitando ingresar
       boolean resultadoObtenido2 = controladoraLogica.autenticarUsuario("kmilo.150c@gmail.com", "Camilo16");
       
       //Se ingresa un correo inexistente donde deberia dar false
       boolean resultadoObtenido3 = controladoraLogica.autenticarUsuario("janjasdnakjdna@gmail.com", "33333333");
       
       Assertions.assertTrue(resultadoObtenido);
       Assertions.assertFalse(resultadoObtenido2);
       Assertions.assertFalse(resultadoObtenido3);
       
       
   }
    
    
    @Test
    public void obtenerClienteAutenticadoTest(){
        
        Cliente resultadoObtenido = controladoraLogica.obtenerClienteAutenticado("kmilo.150c@gmail.com");
        
        List<Cliente> resultadoEsperado = controladoraLogica.getClientes();
        
        Assertions.assertEquals(resultadoEsperado.get(0).getNombrePersona(), resultadoObtenido.getNombrePersona());
        Assertions.assertNotEquals(resultadoEsperado.get(1).getNombrePersona(), resultadoObtenido.getNombrePersona());
        
       
   }
    
    
    
}
