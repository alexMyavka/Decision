import java.util.ArrayList;
import java.util.Scanner;

public class Mission {
    private String name;
    private Inventory inventory;
    private ArrayList<IDecision> decisions;

    public Mission(Inventory inventory, ArrayList<IDecision> decisions, String name) {
        this.inventory = inventory;
        this.decisions = decisions;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void startMission() {
        for (IDecision decision : decisions) {
            decision.Happen(inventory);
            System.out.println("Would you like to leave mission?");
            String answer = new Scanner(System.in).next();
            if (answer.equalsIgnoreCase("yes")) {
                return;
            }
        }
    }
}