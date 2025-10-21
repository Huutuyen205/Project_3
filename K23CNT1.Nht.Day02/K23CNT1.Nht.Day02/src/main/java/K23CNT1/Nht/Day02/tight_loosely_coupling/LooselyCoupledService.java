package K23CNT1.Nht.Day02.tight_loosely_coupling;

public class LooselyCoupledService {
    private SortAlgorithm sortAlgorithm;

    public LooselyCoupledService() {}

    // Dependency Injection qua Constructor
    public LooselyCoupledService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void complexBusiness(int[] array) {
        // Gọi phương thức thông qua interface
        sortAlgorithm.sort(array);
    }

    public static void main(String[] args) {
        // Inject một thể hiện cụ thể vào Constructor
        LooselyCoupledService looselyCoupledService = new LooselyCoupledService(new LooselyBubbleSortAlgorithm());

        looselyCoupledService.complexBusiness(new int[]{11, 21, 13, 42, 15});
    }
}