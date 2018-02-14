package example2;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent servletContextEvent){
ApplicationEnvironment.getInstance().getEmf();
    }
    public void contextDestroyed(ServletContextEvent servletContextEvent){
ApplicationEnvironment.getInstance().getEmf().close();
    }
}
