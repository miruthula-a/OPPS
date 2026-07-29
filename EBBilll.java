import java.util.Scanner;

class CalculateEB {
    int Consumerno;
    String name;
    int PreviousReading, CurrentReading;
    String type;

    double CalculateBill() {
        int unit = CurrentReading - PreviousReading;
        double amount = 0;

        if (type.equalsIgnoreCase("domestic")) {

            if (unit <= 100)
                amount = 0;

            else if (unit <= 200)
                amount = (unit - 100) * 2;

            else if (unit <= 500)
                amount = (100 * 0) + (100 * 2) + (unit - 200) * 4;

            else
                amount = (100 * 0) + (100 * 2) + (300 * 4) + (unit - 500) * 6;
        }

        return amount;
    }
}

public class EBBilll {
    public static void main(String[] args) {

        CalculateEB Eb = new CalculateEB();
        Scanner s = new Scanner(System.in);

        System.out.print("Enter Consumer Number: ");
        Eb.Consumerno = s.nextInt();

        System.out.print("Enter Consumer Name: ");
        Eb.name = s.next();

        System.out.print("Enter Previous Reading: ");
        Eb.PreviousReading = s.nextInt();

        System.out.print("Enter Current Reading: ");
        Eb.CurrentReading = s.nextInt();

        System.out.print("Enter Type (Domestic): ");
        Eb.type = s.next();

        double result = Eb.CalculateBill();

        System.out.println("\nConsumer Number : " + Eb.Consumerno);
        System.out.println("Consumer Name   : " + Eb.name);
        System.out.println("Units Consumed  : " + (Eb.CurrentReading - Eb.PreviousReading));
        System.out.println("Type            : " + Eb.type);
        System.out.println("Amount = " + result);

        s.close();
    }
}