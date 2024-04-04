package example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import example.beans.Capitalist;
import example.beans.College;
import example.beans.Prole;
import example.config.ApplicationConfig;
import example.db.JDBCConnection;
import example.student.Student;

public class Main {
    public static void main(String[] args) throws Exception {
        startApplicationContextWithConfigClass();
    }

    public static void startApplicationContextWithConfigClass() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        College college = context.getBean("collegeBean", College.class);
        college.test();

        // BEANS DEFINED IN CLASS WITH @Component ANNOTATION
        // Capitalist capitalist = context.getBean("capitalist", Capitalist.class);
        // capitalist.getSlave().proleSayHi();
        // Prole prole = context.getBean("prole", Prole.class);
        // prole.getOwner().exploteProle();

        // BEANS DEFINED IN CONFIG CLASS WITH @Bean ANNOTATION
        // Capitalist capitalist1 = context.getBean("capitalistBean", Capitalist.class);
        // capitalist1.getSlave().proleSayHi();
        // Prole prole1 = context.getBean("proleBean", Prole.class);
        // prole1.getOwner().exploteProle();

        Capitalist capitalist2 = context.getBean("anotherCapitalistBean", Capitalist.class);
        capitalist2.getSlave().proleSayHi();
        Prole prole2 = context.getBean("anotherProleBean", Prole.class);
        prole2.getOwner().exploteProle();
        // WE CAN OBSERV THAT QUE CAN SEE BOTH CLASSES IN A FILE, Capitalist and Prole
        // But a method capitalistBean and a method proleBean
    }

    public static void startApplicationContextWithXml() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // Dependency injection with autowired object properties and properties in
        // bean.xml

        Student francock = context.getBean("francock", Student.class);
        francock.cheat();
        Student seve = context.getBean("seve", Student.class);
        seve.cheat();

        // Dependency injection with properties in a separated file
        // OMG connection to DB is so easy wtf brou
        JDBCConnection connection = context.getBean("JDBCConnection",
                JDBCConnection.class);
        connection.display();
        connection.getJDBCConnection();

    }
}