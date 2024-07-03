package persistencia;

import java.util.ArrayList;
import java.util.List;
import logica.Cliente;
import logica.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kmilo
 */

public class ControladoraPersistenciaTest {

    //Se instancia la Clase que se va hacer la prueba.
    private ControladoraPersistencia controlPersistencia;
    private List<Cliente> clientes;
    private List<Usuario> usuarios;
    
    //Lo que hace BeforeEach, es que el metodo creado se ejecute antes de hacer el Test
    @BeforeEach
    public void setUp(){
        controlPersistencia  = new ControladoraPersistencia();
        clientes = new ArrayList<>();
        usuarios  = new ArrayList<>();
    }
    
    @Test
    @DisplayName("Se espera que un cliente este creado y podamos acceder"
            + "a la base de datos y poderlos visualizar por medio del metodo que"
            + "estamos probando 'getCliente'")
    public void testGetClientes(){
        
        //Lo primero es preparar los datos de prueba
        //Llamamos al methodo que vamos a testear
        List<Cliente> resultadoObtenido = controlPersistencia.getClientes();
        
        //Se selecciona un cliente de la lista para conparar
        Cliente resultadoEsperado = resultadoObtenido.get(0);
        
        //Verificamos los resultados obtenidos 
        Assertions.assertEquals(13, resultadoObtenido.size()); //Se verifica que coincida la cantidad de datos en la BD
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido.get(0)); //Se selecciona un cliente de la lista y se compara
        
        //Se verifica que el cliente se encuentre en la lista
        boolean clienteEncontrado = false;
        for(Cliente cliente: resultadoObtenido){
            if(cliente.equals(resultadoEsperado)){
                clienteEncontrado = true;
                break;
            }
        }
        Assertions.assertTrue(clienteEncontrado);
    }
    
    /*
    @Test
    @DisplayName("Se crea un cliente con el metodo 'createCliente'")
    public void crearClienteTest(){
        
        //Preparamos los datos de prueba
        //Cliente cliente;
        Cliente cliente = new Cliente();
        cliente.setNombrePersona("Jose");
        cliente.setApellidosPersona("Lopez");
        cliente.setCorreoElectronico("joselopez@gmail.com");
        cliente.setPassword("Jose12345");
        //llamamos el metodo a probar
        controlPersistencia.crearCliente(cliente);
        
     
        Assertions.assertEquals("Jose", cliente.getNombrePersona());
    }
    */
    
    @Test
    @DisplayName("Se espera que al un usuario este creado para poder guardar"
            + "la la base de datos en una lista y poderlos visualizar por medio"
            + "del metodo que estamos probando getUsuarios")
    public void getUsuarios(){
        
        //Lo primero es preparar los datos de prueba
        //Llamamos al methodo que vamos a testear
        List<Usuario> resultadoObtenido = controlPersistencia.getUsuarios();
        
        //Se selecciona un usuario de la lista para conparar
        Usuario resultadoEsperado = resultadoObtenido.get(0);
        
        
        //Verificamos los resultados obtenidos
        Assertions.assertEquals(8, resultadoObtenido.size());
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido.get(0));
        
        //Se verifica que el usuario se encuentre en la lista
        boolean usuarioEncontrado = false;
        for(Usuario usu: resultadoObtenido){
            if(usu.equals(resultadoEsperado)){
                usuarioEncontrado = true;
                break;
            }
        }
        Assertions.assertTrue(usuarioEncontrado);
    }
    
}
