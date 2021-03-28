import java.util.ArrayList;
import java.util.List;

public class SplitPlainText {

    private List<Integer> values=new ArrayList<>();
    private static final int []E=new int[]{32, 1, 2, 3, 4, 5,
                                            4, 5, 6, 7, 8, 9,
                                            8, 9, 10, 11, 12, 13,
                                            12, 13, 14, 15, 16, 17,
                                            16, 17, 18, 19, 20, 21,
                                            20, 21, 22, 23, 24, 25,
                                            24, 25, 26, 27, 28, 29,
                                            28, 29, 30, 31, 32, 1};
    void expand(){
        List<Integer>copyValues=new ArrayList<>(values);
        for(int i=32;i<48;i++)
            values.add(1);
        for(int i=0;i<48;i++)
            values.set(i, copyValues.get(E[i]-1));

    }
    List<Integer> XOR(List<Integer> item){
        List<Integer>result=new ArrayList<>();
        for(int i=0;i<values.size();i++)
            if(values.get(i)==1 && item.get(i)==1)
                result.add(0);
            else
                result.add(values.get(i)+item.get(i));
            return result;

    }


    void replace(List<Integer>replacedList){
        this.values=new ArrayList<>(replacedList);

    }
    void add(Integer element){
        values.add(element);
    }
    public List<Integer> getValues() {
        return values;
    }
    void clear()
    {
        this.values.clear();
    }

    @Override
    public String toString() {
        return "SplitPlainText{"+
                "values= "+List.of(values).toString()+
                " size= "+values.size()+
                '}';
    }
}
