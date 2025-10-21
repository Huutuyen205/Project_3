package K23CNT1.Nht.Day02;

import java.util.Arrays;

// Giả định class BubbleSortAlgorithm tồn tại và có phương thức sort(int[] arr)
// Class này thể hiện TIGHT COUPLING (Kết hợp chặt chẽ)
public class TightCouplingService {

    // Khai báo và khởi tạo đối tượng BubbleSortAlgorithm, thể hiện TIGHT COUPLING
    // Dòng này khiến TightCouplingService phụ thuộc trực tiếp vào BubbleSortAlgorithm cụ thể.
    private BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

    public TightCouplingService () {
        // Constructor mặc định
    }

    // Constructor có tham số (Có thể dùng cho Dependency Injection, nhưng không được dùng trong main hiện tại)
    public TightCouplingService (BubbleSortAlgorithm bubbleSortAlgorithm) {
        this.bubbleSortAlgorithm = bubbleSortAlgorithm;
    }

    public void complexBusinessSort (int[] arr){
        // Sử dụng thuật toán sắp xếp đã được cố định
        bubbleSortAlgorithm.sort(arr);

        // In các phần tử đã sắp xếp
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        // Khởi tạo dịch vụ, nó sẽ tự động tạo ra một BubbleSortAlgorithm bên trong.
        TightCouplingService tCouplingService = new TightCouplingService();

        // Thực hiện sắp xếp mảng
        tCouplingService.complexBusinessSort(new int[] {11,21,13,42,15});
    }
}