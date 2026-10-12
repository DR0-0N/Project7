import java.util.Random;
import java.util.Scanner;

public class Task1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean repeat;
        do {

            System.out.print("\nEnter number of elements for the array: ");
            int n = scanner.nextInt();

            System.out.println("How do you want to fill the array?");
            System.out.println("1 - Generate random values");
            System.out.println("2 - Manual input");
            System.out.print("Your choice:");
            int choice = scanner.nextInt();

            int[] arr;
            if (choice == 1) {
                arr = createRandomArray(n);
            } else {
                arr = createUserArray(n);
            }

            System.out.println("\nInitial array:");
            printArray(arr);

            bubbleSort(arr);

            System.out.println("\nSorted array:");
            printArray(arr);

            System.out.print("\nDo you want to repeat? (Y/N): ");
            String ans = scanner.next();
            repeat = ans.equalsIgnoreCase("y");

        } while (repeat);

        System.out.println("Program finished.");
        scanner.close();
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int[] createRandomArray(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static int[] createUserArray(int length) {
        int[] arr = new int[length];
        System.out.println("Enter" + length + "integers:");
        for (int i = 0; i < length; i++) {
            System.out.print("Element ["+ i +"]: ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}