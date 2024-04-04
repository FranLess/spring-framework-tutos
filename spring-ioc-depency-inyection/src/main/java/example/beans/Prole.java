package example.beans;

import org.springframework.beans.factory.annotation.Value;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// @Component
public class Prole {

    @Value("${prole1.name}")
    private String name;

    private Capitalist owner;

    public Prole() {
        System.out.println("Calling constructor of Prole");
    }

    public void proleSayHi() {
        System.out.println("Hi im a prole I work as a slave for my lord " + owner.getName());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prole name(String name) {
        setName(name);
        return this;
    }

    public Capitalist getOwner() {
        return this.owner;
    }

    public void setOwner(Capitalist capitalist) {
        this.owner = capitalist;
    }

    public Prole owner(Capitalist capitalist) {
        setOwner(capitalist);
        return this;
    }
}
