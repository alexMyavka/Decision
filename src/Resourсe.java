public class Resourсe {
    private String name;
    private int costPerUnit;

    public Resourсe(String name, int costPerUnit) {
        this.name = name;
        this.costPerUnit = costPerUnit;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return costPerUnit;
    }

}
