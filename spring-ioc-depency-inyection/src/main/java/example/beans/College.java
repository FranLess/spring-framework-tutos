package example.beans;

import org.springframework.stereotype.Component;

@Component("collegeBean")
public class College {
    
    public void test(){
        System.out.println("Testing a bean created by annotation");
    }
}
