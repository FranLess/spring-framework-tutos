package example.beans;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// @Component
public class Capitalist {

    private String name;

    @Autowired
    private Prole slave;

    public Capitalist() {
        System.out.println("Calling constructor of Capitalist");
    }

    public void exploteProle() {
        System.out.println("Work for me fkin stupid " + slave.getName() + " prole u gotta make money");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Capitalist name(String name) {
        setName(name);
        return this;
    }

    public Prole getSlave() {
        return this.slave;
    }

    public void setSlave(Prole prole) {
        this.slave = prole;
    }

    public Capitalist slave(Prole prole) {
        setSlave(prole);
        return this;
    }
}
