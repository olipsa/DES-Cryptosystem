import java.util.ArrayList;
import java.util.List;

public class Pbox {
    private static final int[]P=new int[]{16, 7, 20, 21,
                                        29, 12, 28, 17,
                                        1, 15, 23, 26,
                                        5, 18, 31, 10,
                                        2, 8, 24, 14,
                                        32, 27, 3, 9,
                                        19, 13, 30, 6,
                                        22, 11, 4, 25};
    List<Integer>permutation=new ArrayList<>();
    public Pbox(List<Integer> block) {
        for(int i=0;i<32;i++)
            permutation.add(block.get(P[i]-1));

    }

    public List<Integer> getPermutation() {
        return permutation;
    }
    void replace(List<Integer>replacedList){
        this.permutation=new ArrayList<>(replacedList);

    }
}
