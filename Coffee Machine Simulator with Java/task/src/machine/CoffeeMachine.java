import java.util.*;

record Supplies(int waterPerCup, int milkPerCup, int coffeeBeansPerCup, int price) {}
public class CoffeeMachine {

    /*
    final static int WATER_PER_CUP        = 200;
    final static int MILK_PER_CUP         = 50;
    final static int COFFEE_BEANS_PER_CUP = 15;
    */
    final static Supplies espresso = new Supplies(250, 0,16, 4);
    final static Supplies latte = new Supplies(350, 75, 20, 7);
    final static Supplies cappuccino = new Supplies(200, 100, 12, 6);
    static int actualWater          = 400;
    static int actualMilk           = 540;
    static int actualCoffeeBeans    = 120;
    static int actualDisposableCups = 9;
    static int money                = 550;

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);


//        MakeCoffee();
//        IngredientCalculator(totalCups);

        //<editor-fold desc="Stage 3/4 User request data and raise Calculate Service Method">

        /*
        System.out.println("Write how many ml of water the coffee machine has:");
        int waterQuantity = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkQuantity = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int gramsCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int totalCups = scanner.nextInt();

        CalculateServices(waterQuantity, milkQuantity, gramsCoffeeBeans, totalCups);
        */
        //</editor-fold>

        ActionCoffeeMachine();
    }

    private static void MakeCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    /*
    private static void IngredientCalculator(int totalCups) {
        System.out.printf("For %d cups of coffee you will need:%n", totalCups);
        System.out.printf("%d ml of water%n", totalCups * WATER_PER_CUP);
        System.out.printf("%d ml of milk%n", totalCups * MILK_PER_CUP);
        System.out.printf("%d g of coffee beans", totalCups * COFFEE_BEANS_PER_CUP);

    }
    */

    private static void CalculateServices(Supplies typeOfCoffee) {
    }

    private static void ActionCoffeeMachine() {
        Scanner scanner = new Scanner(System.in);
        String action = "";
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");

            action = scanner.nextLine();

            switch (action) {
                case "buy":
                    BuyCoffee();
                    break;
                case "fill":
                    FillCoffeeMachine();
                    break;
                case "take":
                    System.out.printf("I gave you $%d%n", money);
                    money = 0;
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
                if (actualWater > espresso.waterPerCup()) {
                    actualWater -= espresso.waterPerCup();
                    isWater = true;
                }
                if (actualCoffeeBeans > espresso.coffeeBeansPerCup() && isWater) {
                    actualCoffeeBeans -= espresso.coffeeBeansPerCup();
                    money += 4;
                    isCoffeeBeans = true;
                }
                break;
            case "2":
                if (actualWater > latte.waterPerCup()) {
                    actualWater -= latte.waterPerCup();
                    isWater = true;
                }
                if (actualMilk > latte.milkPerCup() && isWater) {
                    actualMilk -= latte.milkPerCup();
                    isMilk = true;
                }
                if (actualCoffeeBeans > latte.coffeeBeansPerCup() && isMilk) {
                    actualCoffeeBeans -= latte.coffeeBeansPerCup();
                    isCoffeeBeans = true;
                    money += 7;
                }
                break;
            case "3":
                if (actualWater > cappuccino.waterPerCup()) {
                    actualWater -= cappuccino.waterPerCup();
                    isWater = true;
                }
                if (actualMilk > cappuccino.milkPerCup() && isWater) {
                    actualMilk -= cappuccino.milkPerCup();
                    isMilk = true;
                }
                if (actualCoffeeBeans > cappuccino.coffeeBeansPerCup() && isMilk) {
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
