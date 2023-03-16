import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Inventory inventory;
    private Market hub;
    private ArrayList<Mission> missions;
    private int maxMissionIndex = 1;

    public Game(Inventory inventory, Market hub, ArrayList<Mission> missions) {
        this.inventory = inventory;
        this.hub = hub;
        this.missions = missions;
    }

    public void start() {
        System.out.println("Welcome, Player. You stink, go wash yourself. \n " +
                "To wash yourself you need shower. The cost of the shower is " + hub.getShowerCost());
        while (true) {
            for (int i = 0; i < maxMissionIndex; i++) {
                Mission mission = missions.get(i);
                System.out.println(i + ": " + mission.getName());
            }
            System.out.println("Select your mission number, sir");
            Mission mission = missions.get(ConsoleHelper.getNumberWithSubjectToRange(0, missions.size()));
            mission.startMission();
            System.out.println("Would you like to visit market?");
            String answer;
            answer = new Scanner(System.in).next();
            if (answer.equalsIgnoreCase("yes")) {
                hub.startTrading();
            }
            if (inventory.getMoneyCount() >= hub.getShowerCost()) {
                System.out.println("You successfully bought a shower and, finally, you can have a rest");
                return;
            }
        }
    }

}
