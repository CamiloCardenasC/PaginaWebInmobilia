package logica;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kmilo
 */
public class ClienteTest {
    
    public ClienteTest() {
    }
    
    @Test
    public void crearCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombrePersona("Camilo");
        cliente.setApellidosPersona("Cardenas");
        
        assertEquals("Camilo", cliente.getNombrePersona());
        assertEquals("Cardenas", cliente.getApellidosPersona());
    }
}
