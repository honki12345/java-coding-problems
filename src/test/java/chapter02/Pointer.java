package chapter02;

public class Pointer {
    private int x;
    private int y;

    public Pointer() {
    }

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pointer(Pointer pointer) {
        this.x = pointer.x;
        this.y = pointer.y;
    }
}
