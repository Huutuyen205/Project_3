package K23CNT1.Nht.Day02;

import java.util.Arrays;

// Tight coupling
class BubbleSortAlgorithm{
    public void sort(int[] arr){
        System.out.println("Sắp xếp theo giải thuật BubbleSort");
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Perform a pass of bubble sort
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, the array is already sorted
            if (!swapped){
                break;
            }
        }
    }
}