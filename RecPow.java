import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

/**
* The power program will read a set of whole numbers from 'input.txt'.
* It will check if it is a valid whole number.
* If it is not a valid whole number, it will write an error message.
* It will then calculate the power of each valid whole number.
* Finally, it will write the results to 'output.txt'.
*
* @version 1.0
* @since 2025-04-28
*/

final class RecPow {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private RecPow() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the power method.
     *
     * @param base the base.
     * @param exp the exponent.
     * @return the power of the number.
     */

    public static int power(final int base, final int exp) {

        // Base case
        if (exp == 0) {

            // Return 1
            // because x^0 = 1
            return 1;
        } else {

            // Recursive case
            return base * power(base, exp - 1);
        }
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // pass the relative path to the input file as a parameter
        File file = new File("./input.txt");

        // Create a file object
        FileWriter myWriter = new FileWriter("./output.txt");

        // Create a scanner object to read the file
        Scanner scanner = new Scanner(file);

        // Greeting and program description
        System.out.println("Welcome to the power program!");
        System.out.print("This program will read a set");
        System.out.println(" of whole numbers from 'input.txt'.");
        System.out.println("It will check if it is a valid whole number.");
        System.out.print("If it is not a valid whole number,");
        System.out.println(" it will write an error message.");
        System.out.print("It will then calculate the power");
        System.out.println(" of each valid whole number.");
        System.out.println("It will write the results to 'output.txt'.");

        // Keep reading the file until there are no more lines
        while (scanner.hasNextLine()) {

            // Read the string from the file
            String line = scanner.nextLine();

            // Split the string into an array
            String[] numbers = line.split(" ");

            // try to catch invalid input
            try {

                // Convert the base and exponent from a string to an integer
                int base = Integer.parseInt(numbers[0]);
                int exp = Integer.parseInt(numbers[1]);

                // Check if the base and exponent are valid whole numbers
                if (base < 0 || exp < 0) {
                    // If either number is negative
                    outputStr += ("'" + line
                            + "' contains invalid whole numbers.\n"
                    );

                } else {
                    // power function call
                    int power = power(base, exp);

                    // Add the results of the current line to the output string
                    outputStr += (base + "^" + exp + " = " + power + "\n");
                }

            // if the string is not a valid whole number
            } catch (Exception exception) {

                // If the string is not a valid
                // whole number, write an error message
                outputStr += ("'" + line
                        + "' contains invalid whole numbers.\n"
                );
            }
        }

        // Write the output string to the file
        myWriter.write(outputStr);

        // Close the file writer
        myWriter.close();

        // Added a blank line for spacing
        System.out.println("");

        // Display success message
        System.out.println("Successfully wrote to 'output.txt'");

        // Close the scanner
        scanner.close();
    }
}

