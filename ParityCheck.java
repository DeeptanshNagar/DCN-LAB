import java.util.Arrays;

public class ParityCheck {
    // Function to calculate even parity bit (returns 0 or 1)
    public static int calculateParity(int[] data) {
        int parity = 0;
        // Iterates through each bit in the data array.
        for (int bit : data) {
            parity ^= bit; // XOR to count 1s
            // XOR properties:
            // 0 ^ 0 = 0
            // 0 ^ 1 = 1
            // 1 ^ 1 = 0
            // ensures that parity ends up being 1 if the number of 1s is odd, and 0 if it is even
        }
        return parity; // Returns parity bit (0 for even, 1 for odd)
    }

    // Function to check if received data has an error
    public static void checkError(int[] received) {
        int parity = calculateParity(received);
        if (parity == 0)
            System.out.println("No error detected.");
        else
            System.out.println("Error detected in received data!");
    }

    public static void main(String[] args) {
        int[] data = {1, 0, 1, 1, 0, 1, 0}; // 7-bit data
        int[] transmitted = Arrays.copyOf(data, 8); // Extend array to 8 bits

        // Calculate parity and append to transmitted data
        transmitted[7] = calculateParity(data);

        // Display transmitted data
        System.out.print("Transmitted Data: ");
        System.out.println(Arrays.toString(transmitted));

        // Simulating received data (without error)
        int[] received = Arrays.copyOf(transmitted, 8);
        System.out.print("Received Data (No Error): ");
        System.out.println(Arrays.toString(received));
        checkError(received);

        // Simulating received data (with an error)
        received[3] ^= 1; // Flip a bit to introduce an error
        System.out.print("Received Data (With Error): ");
        System.out.println(Arrays.toString(received));
        checkError(received);
    }
}

