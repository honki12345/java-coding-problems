package chapter05;

public class MutableMelon {
    private String type;
    private int weight;

    public MutableMelon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public MutableMelon setType(String type) {
        this.type = type;
        return this;
    }

    public MutableMelon setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public String toString() {
        return "MutableMelon{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }
}
