import java.util.Scanner; // Import Scanner class for user input

public class HammingDistance {
    
    // Function to calculate the Hamming distance between two binary strings
    public static int hammingDistance(String str1, String str2) {
        // Ensure both strings are of the same length
        if (str1.length() != str2.length()) {
            System.out.println("Error: Strings must have the same length!");
            return -1; // Return -1 to indicate an error
        }
        
        int distance = 0; // Variable to count the number of differing bits
        
        // Compare each character of both strings
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) { // If characters differ, increment distance
                distance++;
            }
        }
        
        return distance; // Return the computed Hamming distance
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        
        // Prompt user to enter two binary strings
        System.out.print("Enter the first binary string: ");
        String str1 = scanner.next(); // Read first binary string from user
        
        System.out.print("Enter the second binary string: ");
        String str2 = scanner.next(); // Read second binary string from user
        
        // Calculate the Hamming distance
        int distance = hammingDistance(str1, str2);
        
        // If the distance is valid (not -1), print the result
        if (distance != -1) {
            System.out.println("The Hamming distance between the two strings is: " + distance);
        }
        
        scanner.close(); // Close the Scanner object to prevent resource leaks
    }
}

