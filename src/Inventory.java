import java.util.ArrayList;

public class Inventory {
    private ArrayList<Resourсe> resource = new ArrayList<>();
    private int moneyCount;

    public Inventory(int moneyCount) {
        this.moneyCount = moneyCount;
    }

    public void setMoneyCount(int money) {
        moneyCount += money;
    }

    public int getMoneyCount() {
        return moneyCount;
    }

    public ArrayList<Resourсe> getAll() {
        return (ArrayList<Resourсe>) resource.clone(); //Клонирую лист, чтобы не давать доступ к полю resources
    }

    public void addResources(ArrayList<Resourсe> newResources) {
        resource.addAll(newResources);
    }

    public Resourсe removeResource(int index) {
        Resourсe deletedResource = resource.get(index);
        resource.remove(index);
        return deletedResource;
    }
}