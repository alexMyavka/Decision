import java.util.Scanner;

public class ConsoleHelper {
    public static int getNumberWithSubjectToRange(int min, int max) {
        int itemIndex;
        while (true) {
            try {
                itemIndex = Integer.parseInt(new Scanner(System.in).next());
                if (itemIndex >= min & itemIndex < max) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("I'm repeating(╬▔皿▔)╯, put your god damn number");
            }
        }
        return itemIndex;
    }
}
