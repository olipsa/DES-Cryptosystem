import java.util.ArrayList;
import java.util.List;

public class Ciphertext {
    private static final int[] IP=new int[]{40,	8,	48,	16,	56,	24,	64,	32,
            39,	7,	47,	15,	55,	23,	63,	31,
            38,	6,	46,	14,	54,	22,	62,	30,
            37,	5,	45,	13,	53,	21,	61,	29,
            36,	4,	44,	12,	52,	20,	60,	28,
            35,	3,	43,	11,	51,	19,	59,	27,
            34,	2,	42,	10,	50,	18,	58,	26,
            33,	1,	41,	9,	49,	17,	57,	25
    };
    private final List<Integer>values=new ArrayList<>();

    public Ciphertext(List<Integer>left, List<Integer>right) {
        List<Integer>initialValues=new ArrayList<>();
        for(int i=0;i<32;i++)
            initialValues.add(left.get(i));
        for(int i=32;i<64;i++)
            initialValues.add(right.get(i-32));
        for(int i=0;i<64;i++)
            values.add(initialValues.get(IP[i]-1));
    }

    public List<Integer> getValues() {
        return values;
    }
    public void divide(SplitPlainText left,SplitPlainText right){
        for(int i=0;i<32;i++)
            left.add(values.get(i));
        for(int i=32;i<64;i++)
            right.add(values.get(i));


    }
}
