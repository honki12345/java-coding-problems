package chapter05;

public class ImmutableMelon {
    private final String type;

    private final int weight;

    public ImmutableMelon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }
}
