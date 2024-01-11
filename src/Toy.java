public class Toy {
    private long id;
    private String name;
    private int count;
    private double weight;

    public Toy(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Toy(long id, String name, int count, double weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Toy " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", count = " + count +
                ", weight = " + weight;
    }
}
