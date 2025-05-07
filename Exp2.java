
public class Exp2 {
    public static String bitStuffing(String data) {
        StringBuilder stuffedData = new StringBuilder();
        int count = 0;
        for (char bit : data.toCharArray()) {
            if (bit == '1') {
                count++;
            } else {
                count = 0;
            }

            stuffedData.append(bit);
            if (count == 5) {
                stuffedData.append('0');
                count = 0; 
            }
        }
        return stuffedData.toString();
    }
    
    public static String bitDestuffing(String stuffedData) {
        StringBuilder destuffedData = new StringBuilder();
        int count = 0;

        for (int i = 0; i < stuffedData.length(); i++) {
            char bit = stuffedData.charAt(i);
            destuffedData.append(bit);

            if (bit == '1') {
                count++;
            } else {
                count = 0;
            }
            if (count == 5 && i + 1 < stuffedData.length() && stuffedData.charAt(i + 1) == '0') {
                i++; 
            }
        }
        return destuffedData.toString();
    }

    public static void main(String[] args) {
        String originalData = "111110111111000011111";
        System.out.println("Original Data: " + originalData);

        String stuffed = bitStuffing(originalData);
        System.out.println("Stuffed Data: " + stuffed);

        String destuffed = bitDestuffing(stuffed);
        System.out.println("De-stuffed Data: " + destuffed);
        if (originalData.equals(destuffed)) {
            System.out.println("De-stuffed data matches the original!");
        } else {
            System.out.println("De-stuffed data does not match the original!");
        }
    }
}
