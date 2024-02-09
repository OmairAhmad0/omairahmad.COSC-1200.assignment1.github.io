import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        // Double variables store returned rate doubles from respective classes.
        double rateUSD = (new USD()).rate;
        double rateGBP = (new GBP()).rate;
        double rateEUR = (new EUR()).rate;
        double cadAmount = 0.0;
        double finalAmount = 0.0;
        char symbol = '$';

        // Asks user for the type of currency they want to convert from displayed options.
        System.out.println("Select the currency you are using:\n1. CAD\n2. USD\n3. GBP\n4. EUR");
        int selectedCurrency = keyboard.nextInt();
        // Asks user for the type of currency they want to convert to from displayed options.
        System.out.println("Select the currency are converting to:\n1. CAD\n2. USD\n3. GBP\n4. EUR");
        int outputCurrency = keyboard.nextInt();
        // Asks user for the amount of money they want to convert.
        System.out.println("Enter the amount you want to convert: ");
        double amount = keyboard.nextDouble();

        // Switch block converts the inputted money amount to its CAD equivalent.
        switch (selectedCurrency) {
            case 1:
                // CAD
                cadAmount = amount;
                break;
            case 2:
                // USD
                cadAmount = amount / rateUSD;
                break;
            case 3:
                // GBP
                cadAmount = amount / rateGBP;
                break;
            case 4:
                // EUR
                cadAmount = amount / rateEUR;
                break;
            default:
                System.out.println("Invalid input.");
        }

        // Switch block converts the converted CAD amount into the selected currency.
        switch (outputCurrency) {
            case 1:
                // CAD
                finalAmount = cadAmount;
                break;
            case 2:
                // USD
                finalAmount = cadAmount * rateUSD;
                break;
            case 3:
                // GBP
                finalAmount = cadAmount * rateGBP;
                symbol = '£';
                break;
            case 4:
                // EUR
                finalAmount = cadAmount * rateEUR;
                symbol = '€';
                break;
            default:
                System.out.println("Invalid input.");
        }
        
        // Output formatted to two decimal places.
        System.out.println("The converted amount is: " + symbol + String.format("%.2f", finalAmount));
    }
}