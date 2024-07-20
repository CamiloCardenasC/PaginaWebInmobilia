package contextListener;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

@WebListener
public class JdbcDriverListener implements ServletContextListener{
    
    /*
    * Cancela el registro de los controladores JDBC distribuidos con la aplicación.
    */
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        final ClassLoader cl = sce.getServletContext().getClassLoader();
        final Enumeration<Driver> drivers = DriverManager.getDrivers();
        
        while (drivers.hasMoreElements()) {
            final Driver driver = drivers.nextElement();
            
            //Damos de baja solo las clases cargadas por el cargador de clases de esta aplicación
            if (driver.getClass().getClassLoader() == cl){
                try {
                    DriverManager.deregisterDriver(driver);
                } catch (Exception e) {
                    sce.getServletContext().log("JDBC Driver deregistration failure.", e);
                }
                
            }
            
        }
    }
    
    
    /**
     * Registra los controladores JDBC distribuidos con la aplicación.
     * 
     * @param sce
     */
    
    
    @Override
    public void contextInitialized (ServletContextEvent sce){
        
    }
}
