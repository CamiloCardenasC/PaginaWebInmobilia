package contextListener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 *
 * @author kmilo
 */
@WebListener
public class JdbcDriverListener2 implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            java.sql.Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
    
    
    
    
    
}
