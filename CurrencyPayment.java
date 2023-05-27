import java.util.*;

public class CurrencyPayment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of currency denominations
        System.out.print("Enter the size of currency denominations: ");
        int size = scanner.nextInt();

        // Input the currency denominations values
        System.out.println("Enter the currency denominations value:");
        int[] denominations = new int[size];
        for (int i = 0; i < size; i++) {
            denominations[i] = scanner.nextInt();
        }

        // Input the amount to pay
        System.out.print("Enter the amount you want to pay: ");
        int amount = scanner.nextInt();

        // Sort the denominations in descending order
        Arrays.sort(denominations);
        reverseArray(denominations);

        // Calculate the minimum number of notes
        int[] notesCount = new int[size];
        for (int i = 0; i < size; i++) {
            notesCount[i] = amount / denominations[i];
            amount %= denominations[i];
        }

        // Output the payment approach
        System.out.println("Your payment approach in order to give the minimum number of notes will be:");
        for (int i = 0; i < size; i++) {
            if (notesCount[i] > 0) {
                System.out.println(denominations[i] + ":" + notesCount[i]);
            }
        }
    }

    // Helper method to reverse an array
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
