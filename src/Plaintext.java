import java.util.ArrayList;
import java.util.List;

public class Plaintext {
    private final List<Integer> values=new ArrayList<>();
    private static final int []IP=new int[]{58, 50, 42, 34, 26, 18, 10, 2,
                                    60, 52, 44, 36, 28, 20, 12, 4,
                                    62, 54, 46, 38, 30, 22, 14, 6,
                                    64, 56, 48, 40, 32, 24, 16, 8,
                                    57, 49, 41, 33, 25, 17, 9, 1,
                                    59, 51, 43, 35, 27, 19, 11, 3,
                                    61, 53, 45, 37, 29, 21, 13, 5,
                                    63, 55, 47, 39, 31, 23, 15, 7};


    public Plaintext() {
        for(int i=0;i<64;i++)
            values.add((int)(Math.random()*2));
    }

    public List<Integer> getValues() {
        return values;
    }

    public void initialPermutation(){
        List<Integer>copyValues=new ArrayList<>(values);
        //Transposition according to IP matrix
        for(int i=0;i<64;i++)
            values.set(i,copyValues.get(IP[i]-1));
    }
    public void divide(SplitPlainText left,SplitPlainText right){
        for(int i=0;i<32;i++)
            left.add(values.get(i));
        for(int i=32;i<64;i++)
            right.add(values.get(i));


    }
    public void clear(){
        this.values.clear();
    }

}
