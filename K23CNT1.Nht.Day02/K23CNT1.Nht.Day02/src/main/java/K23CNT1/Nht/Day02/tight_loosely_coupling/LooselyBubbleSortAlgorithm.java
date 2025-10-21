package K23CNT1.Nht.Day02.tight_loosely_coupling;

import java.util.Arrays;

// Lớp triển khai interface
public class LooselyBubbleSortAlgorithm implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorted using bubble sort algorithm");

        // Sử dụng standard Java sort cho ví dụ này (giống code bạn cung cấp)
        Arrays.stream(array).sorted().forEach(System.out::println);
    }
}