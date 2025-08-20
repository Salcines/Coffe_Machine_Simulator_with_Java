import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Write how many cups of coffee you will need: ");
        int totalCups = scanner.nextInt();

        IngredientCalculator(totalCups);

    }

    private static void IngredientCalculator(int totalCups) {

        final int WATER_PER_CUP = 200;
        final int MILK_PER_CUP = 50;
        final int COFFEE_BEANS_PER_CUP = 15;

        System.out.printf("For %d cups of coffee you will need:%n", totalCups);
        System.out.printf("%d ml of water%n", totalCups * WATER_PER_CUP);
        System.out.printf("%d ml of milk%n", totalCups * MILK_PER_CUP);
        System.out.printf("%d g of coffee beans", totalCups * COFFEE_BEANS_PER_CUP);

    }

    public static void MakeCoffe() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

}
