import java.util.ArrayList;

public class Main {
    private static Game gameInitialization() {
        Inventory inventory = new Inventory(0);
        ArrayList<Resourсe> inventoryResource = new ArrayList<>(1);
        inventory.addResources(inventoryResource);
        Market hub = new Market(inventory);
        Resourсe gold = new Resourсe("Gold", 10);
        Resourсe silver = new Resourсe("Silver", 5);
        Resourсe copper = new Resourсe("Copper", 3);
        Resourсe wood = new Resourсe("Wood", 1);
        ArrayList<Resourсe> hubResources = new ArrayList<>();
        hubResources.add(gold);
        hubResources.add(silver);
        hubResources.add(copper);
        hubResources.add(wood);
        hub.setHubResources(hubResources);
        hub.setShowerCost(50);
        ArrayList<Resourсe> reward1 = new ArrayList<>();
        reward1.add(wood);
        reward1.add(copper);
        ArrayList<Resourсe> reward2 = new ArrayList<>();
        reward2.add(gold);
        reward2.add(silver);
        reward2.add(copper);
        ArrayList<IDecision> decisions = new ArrayList<>();
        IDecision mistery1 = new Mistery("You approach strange creature. It askes: Wie kann Mann so klein Schwanz haben?", "Natürlich", reward1);
        IDecision riskDecision1 = new RiskDecision("You see a strange cave. It's shiny. Will you enter in?", 15, reward2);
        decisions.add(mistery1);
        decisions.add(riskDecision1);
        ArrayList<Mission> missions = new ArrayList<>();
        Mission mission = new Mission(inventory, decisions, "GlavGad");
        missions.add(mission);
        return new Game(inventory, hub, missions);
    }

    public static void main(String[] args) {
        gameInitialization().start();
    }
}
