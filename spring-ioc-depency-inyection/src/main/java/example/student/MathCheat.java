package example.student;

public class MathCheat {
    private String name;

    public MathCheat() {
        System.out.println("Constructor call of MathCheat");
    }

    public void cheat() {
        System.out.println("Cheating from " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
