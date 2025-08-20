import java.util.*;

public class CoffeeMachine {

    final static int WATER_PER_CUP = 200;
    final static int MILK_PER_CUP = 50;
    final static int COFFEE_BEANS_PER_CUP = 15;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterQuantity = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkQuantity = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int gramsCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int totalCups = scanner.nextInt();

        CalculateServices(waterQuantity, milkQuantity, gramsCoffeeBeans, totalCups);


//        IngredientCalculator(totalCups);


//      MakeCoffee();
    }

    private static void CalculateServices(int waterQuantity, int milkQuantity, int gramsCoffeeBeans, int totalCups) {
        List<Integer> cups = new ArrayList<Integer>();
        cups.add(waterQuantity / WATER_PER_CUP);
        cups.add(milkQuantity / MILK_PER_CUP);
        cups.add(gramsCoffeeBeans / COFFEE_BEANS_PER_CUP);

        Collections.sort(cups);

        int availableCups = cups.get(0);

        if (availableCups == totalCups) {
            System.out.println("Yes, I can make that amount of coffee");
        }

        if (availableCups > totalCups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)",
                    availableCups - totalCups);
        }

        if (availableCups < totalCups) {
            System.out.printf("No, I can make only %d cup(s) of coffee", availableCups);
        }

    }

    private static void IngredientCalculator(int totalCups) {
        System.out.printf("For %d cups of coffee you will need:%n", totalCups);
        System.out.printf("%d ml of water%n", totalCups * WATER_PER_CUP);
        System.out.printf("%d ml of milk%n", totalCups * MILK_PER_CUP);
        System.out.printf("%d g of coffee beans", totalCups * COFFEE_BEANS_PER_CUP);

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

}
