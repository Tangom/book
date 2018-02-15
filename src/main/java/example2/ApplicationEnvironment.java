package example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@ComponentScan(basePackages ="example2" )
public class ApplicationEnvironment {
    @Bean
    public EntityManagerFactory getFactory() {
        return  Persistence.createEntityManagerFactory("TestPersistenceUnit");
    }
     @Bean
    public EntityManager getEntityManager (EntityManagerFactory emf){
        return emf.createEntityManager();
    }
    @Bean
    public ViewResolver getResolver (){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver ();
        resolver.setSuffix(".jsp");
        resolver.setPrefix("/");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
