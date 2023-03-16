import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RiskDecision implements IDecision {
    private String interMission;
    private int chanceToWin;
    private ArrayList<Resourсe> prize;

    public RiskDecision(String interMission, int chanceToWin, ArrayList<Resourсe> prize) {
        this.interMission = interMission;
        this.chanceToWin = chanceToWin;
        this.prize = prize;
    }

    @Override
    public void Happen(Inventory inventory) {
        System.out.println(interMission);
        String playerAnswer = new Scanner(System.in).next();
        if (!playerAnswer.equalsIgnoreCase("yes")) {
            System.out.println("You thoughtless passed by this");
            return;
        }
        if (new Random().nextInt(100) >= chanceToWin) {
            System.out.println("Intelligence check successfully passed");
            inventory.addResources(prize);
            return;
        }
        System.out.println("You lost all your social credits and your train to gulag is on the way");
        System.out.println("He is coming to you. RUN!!!");
        for (int i = 0; i < 2000; i++) {
            System.out.println(i + "meters");
        }
        inventory.removeResource(new Random().nextInt(inventory.getAll().size()));
    }
}