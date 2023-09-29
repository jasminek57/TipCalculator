import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TipCalculator {
    public static void main (String[] args)
    {
        //intro statements and values collected
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to tip calculator!");
        System.out.print("How many people are eating today? ");
        int people = scan.nextInt();
        scan.nextLine();
        System.out.print("How much money would you like to donate? ");
        double donate = scan.nextDouble();
        donate = Math.round((donate) * 100.0) / 100.0;
        System.out.print("Enter your tip percentage as an integer (0-100): ");
        int percent = scan.nextInt();

        //variable for loop declared
        double totalPrice = 0;
        double price = 0;
        List<String> list = new ArrayList<String>();

        //loop for customer values
        while (price != -1) {
            System.out.print("Enter the cost of a item in dollars and cents (-1 to stop): ");
            price = scan.nextDouble();
            scan.nextLine();
            if (price != -1) {
                totalPrice += price;
                System.out.print("Enter the item: ");
                String item = scan.nextLine();
                list.add(item);
            }
        }
        System.out.println("------------------------------------------------------------------");

        //variables dealt with and rounded
        double perPerson = totalPrice / people;
        double tip = (percent * totalPrice) / 100;
        double singularTip = tip / people;
        perPerson = Math.round((perPerson) * 100.0) / 100.0;
        singularTip = Math.round((singularTip) * 100.0) / 100.0;
        tip = Math.round((tip) * 100.0) / 100.0;
        double perDonate = donate / people;
        perDonate = Math.round((perDonate) * 100.0) / 100.0;
        double costPerPerson = Math.round(singularTip + perPerson + perDonate);

        //all values printed
        System.out.println("Total price before tip: $" + String.format("%.2f", totalPrice));
        System.out.println("Your tip percentage will be " + percent + "%");
        System.out.println("Tip total: $" + String.format("%.2f", tip));
        System.out.println("Total bill including tip and donation: $" + String.format("%.2f", (tip + totalPrice + donate)));
        System.out.println("Price per person before tip: $" + String.format("%.2f", perPerson));
        System.out.println("Tip per person: $" + String.format("%.2f", singularTip));
        System.out.println("Total cost per person including donation: $" + String.format("%.2f", costPerPerson));
        System.out.println("------------------------------------------------------------------");

        System.out.println("Items ordered: ");
        list.forEach(System.out::println);
    }
}



