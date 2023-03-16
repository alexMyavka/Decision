import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Mistery implements IDecision {
    private String text;
    private String answer;
    private ArrayList<Resourсe> reward;

    public Mistery(String text, String answer, ArrayList<Resourсe> reward) {
        this.text = text;
        this.answer = answer;
        this.reward = reward;
    }

    @Override
    public void Happen(Inventory inventory) {
        System.out.println(text);
        String playerAnswer = new Scanner(System.in).next();
        if (playerAnswer.equalsIgnoreCase(answer)) {
            System.out.println("You're god damn right, Player, ur god damn right");
            inventory.addResources(reward);
            return;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("The Wrong answer incident \n" + dtf.format(now));
        System.out.println("Right answer is " + answer);
    }
}
