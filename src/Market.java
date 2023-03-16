import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Market {
    private Inventory inventory;
    private ArrayList<Resourсe> hubResources = new ArrayList<>();
    private int showerCost;

    public Market(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setShowerCost(int showerCost) {
        this.showerCost = showerCost;
    }

    public int getShowerCost() {
        return showerCost;
    }

    public void setHubResources(ArrayList<Resourсe> hubResources) {
        this.hubResources = hubResources;
    }

    public void sellResource(int index) {
        Resourсe soldResource = inventory.getAll().get(index);
        inventory.setMoneyCount(soldResource.getCost());
        inventory.removeResource(index);
        hubResources.add(soldResource);
        System.out.println("Now you have " + inventory.getMoneyCount() + " money");
    }

    public void buyResourсe(int index) {
        Resourсe boughtResourсe = hubResources.get(index);
        if (inventory.getMoneyCount() - boughtResourсe.getCost() < 0) {
            System.out.println("Sorry, Player. I can't give credit. Come back when you're a little... mmmmm... richer!");
            return;
        }
        inventory.setMoneyCount(-boughtResourсe.getCost());
        ArrayList<Resourсe> boughtResources = new ArrayList<>();
        boughtResources.add(boughtResourсe);
        inventory.addResources(boughtResources);
        hubResources.removeAll(boughtResources);
    }

    public void startTrading() {
        while (true) {
            System.out.println("Do you want to sell, buy or go to work");
            String playerWish = new Scanner(System.in).next();
            switch (playerWish.toLowerCase(Locale.ROOT)) {
                case ("sell"): {
                    if (inventory.getAll().size() == 0) {
                        System.out.println("You have noting to sell. Go to work!");
                        break;
                    }
                    for (int i = 0; i < inventory.getAll().size(); i++) {
                        Resourсe resourсe = inventory.getAll().get(i);
                        System.out.println(i + ": " + resourсe.getName());
                    }
                    System.out.println("What item do YOU want to sell?");
                    sellResource(ConsoleHelper.getNumberWithSubjectToRange(0, inventory.getAll().size()));
                }
                break;
                case ("buy"): {
                    for (int i = 0; i < hubResources.size(); i++) {
                        Resourсe resourсe = hubResources.get(i);
                        System.out.println(i + ": " + resourсe.getName());
                    }
                    System.out.println("You have " + inventory.getMoneyCount() + " money");
                    System.out.println("What item do you wanna sell to you?");
                    buyResourсe(ConsoleHelper.getNumberWithSubjectToRange(0, hubResources.size()));
                }
                break;
                default:
                    System.out.println("Goodbye, see you next 10 strings");
                    return;
            }
        }
    }
}