import java.util.Scanner;


public class CRC1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message bits: ");   // data to be transmitted
        String message = sc.nextLine();
        System.out.print("Enter generator: ");      // generator polynomial for crc calculation
        String generator = sc.nextLine();

        int data[] = new int[message.length() + generator.length() - 1];
        int divisor[] = new int[generator.length()];

        for (int i = 0; i < message.length(); i++)
            data[i] = Integer.parseInt(message.charAt(i) + ""); // Stores the message bits with extra bits appended for CRC.
        for (int i = 0; i < generator.length(); i++)
            divisor[i] = Integer.parseInt(generator.charAt(i) + ""); // Stores the generator polynomial as an array of integers

        // Calculation of CRC
        for (int i = 0; i < message.length(); i++) {
            if (data[i] == 1)
                for (int j = 0; j < divisor.length; j++)
                    data[i + j] ^= divisor[j];
        } // It iterates through the data[] and performs XOR with divisor[] whenever the current bit is 1.

        
        System.out.print("The checksum code is: ");
        for (int i = 0; i < message.length(); i++)
            data[i] = Integer.parseInt(message.charAt(i) + "");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i]);
        System.out.println();
		// It prints the message bits followed by the calculated CRC checksum.

        
        System.out.print("Enter checksum code: ");
        message = sc.nextLine();
        System.out.print("Enter generator: ");
        generator = sc.nextLine();
		// user to enter the received message with checksum.
		// user to enter the same generator polynomial.

        data = new int[message.length() + generator.length() - 1];
        divisor = new int[generator.length()];
		// Creates new arrays to store the received message and divisor

        for (int i = 0; i < message.length(); i++) // Converts each character of message and generator into integer values (0 or 1) and stores them in data[] and divisor[].
            data[i] = Integer.parseInt(message.charAt(i) + "");
        for (int i = 0; i < generator.length(); i++)
            divisor[i] = Integer.parseInt(generator.charAt(i) + "");
			// Converts the received message and generator into integer arrays.

        
        for (int i = 0; i < message.length(); i++) {
            if (data[i] == 1)
                for (int j = 0; j < divisor.length; j++)
                    data[i + j] ^= divisor[j];
        } 
		// Performs XOR division again to check for errors.

        // Display validity of data
        boolean valid = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                valid = false;
                break;
            }
        }
// 		If all bits in the remainder are 0, the received message is valid.
// Otherwise, an error occurred.


        if (valid)
            System.out.println("Data stream is valid");
        else
            System.out.println("Data stream is invalid. CRC error occurred.");
			//Prints whether the received message is correct or corrupted
    }
}
