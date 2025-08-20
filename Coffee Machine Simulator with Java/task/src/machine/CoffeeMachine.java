import java.util.*;

record Supplies(int waterPerCup, int milkPerCup, int coffeeBeansPerCup, int price) {}
public class CoffeeMachine {

    final static Supplies espresso = new Supplies(250, 0,16, 4);
    final static Supplies latte = new Supplies(350, 75, 20, 7);
    final static Supplies cappuccino = new Supplies(200, 100, 12, 6);
    static int actualWater          = 400;
    static int actualMilk           = 540;
    static int actualCoffeeBeans    = 120;
    static int actualDisposableCups = 9;
    static int money                = 550;
    static int cupsMade = 0;

    public static void main(String[] args) {

        ActionCoffeeMachine();
    }

    private static void ActionCoffeeMachine() {
        Scanner scanner = new Scanner(System.in);
        String action = "";
        do {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");

            action = scanner.nextLine();

            switch (action) {
                case "buy":
                    if (cupsMade < 10) {
                        BuyCoffee();
                    } else {
                        System.out.println("I need cleaning!");
                    }
                    break;
                case "fill":
                    FillCoffeeMachine();
                    break;
                case "take":
                    System.out.printf("I gave you $%d%n", money);
                    money = 0;
                    break;
                    case "clean":
                        System.out.println("I have been cleaned!");
                        cupsMade = 0;
                        break;
                case "remaining":
                    MessageOutput();
                    break;
                default:
                    break;
            }
            System.out.println();
        } while (!action.equals("exit"));
    }

    private static void MessageOutput() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", actualWater);
        System.out.printf("%d ml of milk%n", actualMilk);
        System.out.printf("%d g of coffee beans%n", actualCoffeeBeans);
        System.out.printf("%d disposable cups%n", actualDisposableCups);
        System.out.printf("$%d of money%n", money);
    }

    private static void BuyCoffee() {
        Scanner scanner = new Scanner(System.in);
        boolean isWater = false;
        boolean isMilk = false;
        boolean isCoffeeBeans = false;
        boolean isCups = false;

        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back to main menu:");
        String coffeeCups = scanner.nextLine();

        switch (coffeeCups) {
            case "1":
                isMilk = true;
                if (actualWater >= espresso.waterPerCup()) {
                    actualWater -= espresso.waterPerCup();
                    isWater = true;
                }
                if (actualCoffeeBeans >= espresso.coffeeBeansPerCup() && isWater) {
                    actualCoffeeBeans -= espresso.coffeeBeansPerCup();
                    money += 4;
                    isCoffeeBeans = true;
                }
                break;
            case "2":
                if (actualWater >= latte.waterPerCup()) {
                    actualWater -= latte.waterPerCup();
                    isWater = true;
                }
                if (actualMilk >= latte.milkPerCup() && isWater) {
                    actualMilk -= latte.milkPerCup();
                    isMilk = true;
                }
                if (actualCoffeeBeans >= latte.coffeeBeansPerCup() && isMilk) {
                    actualCoffeeBeans -= latte.coffeeBeansPerCup();
                    isCoffeeBeans = true;
                    money += 7;
                }
                break;
            case "3":
                if (actualWater >= cappuccino.waterPerCup()) {
                    actualWater -= cappuccino.waterPerCup();
                    isWater = true;
                }
                if (actualMilk >= cappuccino.milkPerCup() && isWater) {
                    actualMilk -= cappuccino.milkPerCup();
                    isMilk = true;
                }
                if (actualCoffeeBeans >= cappuccino.coffeeBeansPerCup() && isMilk) {
                    actualCoffeeBeans -= cappuccino.coffeeBeansPerCup();
                    isCoffeeBeans = true;
                    money += 6;
                }
                break;
            case "back":
                return;
            default:
                break;
        }
        isCups = (actualDisposableCups > 0);

        if (isWater && isMilk && isCoffeeBeans && isCups) {
            System.out.println("I have enough resources, making you a coffee!");
            actualDisposableCups--;
            cupsMade++;
        } else if (!isWater) {
            System.out.println("Sorry, not enough water!");
        } else if (!isMilk) {
            System.out.println("Sorry, not enough milk");
        } else if (!isCoffeeBeans) {
            System.out.println("Sorry, not enough coffee beans");
        } else if (!isCups) System.out.println("Sorry, not enough cups");

    }

    private static void FillCoffeeMachine() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Write how many ml of water you want to add:");
        actualWater += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        actualMilk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        actualCoffeeBeans += scanner.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        actualDisposableCups += scanner.nextInt();
    }

}
