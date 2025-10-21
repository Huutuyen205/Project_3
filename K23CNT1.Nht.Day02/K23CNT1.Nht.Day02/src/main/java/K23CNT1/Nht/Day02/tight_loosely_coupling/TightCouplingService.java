package K23CNT1.Nht.Day02.tight_loosely_coupling;
import java.util.Arrays;

// Lớp dịch vụ khớp nối chặt
public class TightCouplingService {
    // Khớp nối chặt: Khởi tạo trực tiếp BubbleSortAlgorithm
    private BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

    public TightCouplingService() {}

    public TightCouplingService(BubbleSortAlgorithm bubbleSortAlgorithm) {
        this.bubbleSortAlgorithm = bubbleSortAlgorithm;
    }

    public void complexBusinessSort(int[] arr) {
        bubbleSortAlgorithm.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        TightCouplingService tCouplingService = new TightCouplingService();
        tCouplingService.complexBusinessSort(new int[]{11, 21, 13, 42, 15});
    }
}