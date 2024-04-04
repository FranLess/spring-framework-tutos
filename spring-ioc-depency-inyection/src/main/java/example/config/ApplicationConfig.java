package example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import example.beans.Capitalist;
import example.beans.Prole;

@Configuration
// WE CAN SCAN ALL CLASSES WITH A COMPONENT ANNOTATION OVER IT
// THOSE ARE A BEAN
@ComponentScan(basePackages = { "example" })
@PropertySource("classpath:capitalism.properties")
public class ApplicationConfig {

    @Value("${capitalist1.name}")
    private String capitalistName1;

    @Value("${capitalist2.name}")
    private String capitalistName2;

    // WE CAN DEFINE BEAN INSIDE CONFIG CLASS
    // WE DEFINE THESE BEANS A PRIMARY TO NOT HAVE CONFLICT IN AUTOWIRED DEPENDECIES
    @Bean
    @Primary
    public Capitalist capitalistBean() {
        return new Capitalist()
                .name(capitalistName1);
    }

    @Bean
    public Capitalist anotherCapitalistBean() {
        return new Capitalist()
                .name(capitalistName2);
    }

    @Bean
    @Primary
    public Prole proleBean() {
        return new Prole()
                .owner(capitalistBean());
    }

    @Bean
    public Prole anotherProleBean() {
        return new Prole()
                .owner(anotherCapitalistBean());
    }
}
