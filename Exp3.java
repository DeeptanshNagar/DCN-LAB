import java.io.ByteArrayOutputStream;

public class Exp3 {

    public static byte[] byteStuffing(byte[] inputData, byte flag, byte escape) {
        /*
         * Perform byte stuffing on input data.
         *
         * Args:
         * inputData: The data to be stuffed.
         * flag: The flag byte.
         * escape: The escape byte.
         *
         * Returns:
         * The stuffed data as a byte array.
         */
        ByteArrayOutputStream stuffedData = new ByteArrayOutputStream();
        stuffedData.write(flag); // Add start flag

        for (byte b : inputData) {
            if (b == flag || b == escape) {
                stuffedData.write(escape);
                stuffedData.write(b ^ 0x20); // XOR with 0x20 for escape encoding
            } else {
                stuffedData.write(b);
            }
        }

        stuffedData.write(flag); // Add end flag
        return stuffedData.toByteArray();
    }

    public static byte[] byteUnstuffing(byte[] stuffedData, byte flag, byte escape) throws IllegalArgumentException {
        /*
         * Perform byte unstuffing on stuffed data.
         *
         * Args:
         * stuffedData: The stuffed data.
         * flag: The flag byte.
         * escape: The escape byte.
         *
         * Returns:
         * The original unstuffed data as a byte array.
         */
        if (stuffedData[0] != flag || stuffedData[stuffedData.length - 1] != flag) {
            throw new IllegalArgumentException("Invalid data: missing start or end flag.");
        }

        ByteArrayOutputStream unstuffedData = new ByteArrayOutputStream();

        for (int i = 1; i < stuffedData.length - 1; i++) { // Exclude start and end flags
            byte b = stuffedData[i];
            if (b == escape) {
                i++;
                if (i >= stuffedData.length - 1) {
                    throw new IllegalArgumentException("Invalid escape sequence.");
                }
                unstuffedData.write(stuffedData[i] ^ 0x20); // Reverse escape encoding
            } else {
                unstuffedData.write(b);
            }
        }

        return unstuffedData.toByteArray();
    }

    public static void main(String[] args) {
        byte flag = 0x7E;  // Flag byte
        byte escape = 0x7D; // Escape byte

        // Input data as bytes, including the flag and escape bytes
        byte[] data = new byte[]{ 'H', 'e', 'l', 'l', 'o', ',', ' ', 0x7E, 0x7D, ' ', 'w', 'o', 'r', 'l', 'd', '!' };
        System.out.println("Original data: " + new String(data));

        byte[] stuffed = byteStuffing(data, flag, escape);
        System.out.println("Stuffed data: " + new String(stuffed));

        try {
            byte[] unstuffed = byteUnstuffing(stuffed, flag, escape);
            System.out.println("Unstuffed data: " + new String(unstuffed));
            assert java.util.Arrays.equals(data, unstuffed);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
