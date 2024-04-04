package example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {

    private int id;
    private String name;
    // Autowired doesn't need a constructor nor a setter to set inject the
    // dependency
    @Autowired
    // Quialifier sets the reference to a id of a bean
    // @Qualifier("mathCheat")
    @Qualifier("anotherMathCheat")
    private MathCheat mathCheat;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public void setMathCheat(MathCheat mathCheat) {
    // this.mathCheat = mathCheat;
    // }

    public void cheat() {
        mathCheat.cheat();
        System.out.println(name + " has started cheating...");
    }
}
