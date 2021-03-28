import java.util.ArrayList;
import java.util.List;

public class Key {
    private List<Integer> values=new ArrayList<>();
    private List<Integer> initialValues=new ArrayList<>();
    private static final int []PC1=new int[]{57, 49, 41, 33, 25, 17, 9,
                                            1, 58, 50, 42, 34, 26, 18,
                                            10, 2, 59, 51, 43, 35, 27,
                                            19, 11, 3, 60, 52, 44, 36,
                                            63, 55, 47, 39, 31, 23, 15,
                                            7, 62, 54, 46, 38, 30, 22,
                                            14, 6, 61, 53, 45, 37, 29,
                                            21, 13, 5, 28, 20, 12, 4};
    private static final int []leftRotations=new int[]{1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};
    private static final int []PC2=new int[]{14, 17, 11, 24, 1, 5,
                                            3, 28, 15, 6, 21, 10,
                                            23, 19, 12, 4, 26, 8,
                                            16, 7, 27, 20, 13, 2,
                                            41, 52, 31, 37, 47, 55,
                                            30, 40, 51, 45, 33, 48,
                                            44, 49, 39, 56, 34, 53,
                                            46, 42, 50, 36, 29, 32};
    public Key(){
        for(int i=0;i<64;i++)
            values.add((int)(Math.random()*2));
    }
    public void dropParityBits(){
        //Transposition according to PC1 matrix
        initialValues=new ArrayList<>(values);
        for(int i=0;i<56;i++)
            values.set(i,initialValues.get(PC1[i]-1));
        for(int i=56;i<values.size();i++)
        {
            values.remove(i);
            i--;
        }
        initialValues=new ArrayList<>(values);
    }
    public void bitsRotation(int roundNumber){
        int numberOfRotations=leftRotations[roundNumber];
        int firstBit;
        values=new ArrayList<>(initialValues);
        while(numberOfRotations!=0){
            //Shift left and right part of the key
            for(int first=0;first<=28;first+=28){
                firstBit=values.get(first);
                for(int i=first;i<first+27;i++){
                    values.set(i,values.get(i+1));
                }
                values.set(first+27,firstBit);
            }

            numberOfRotations--;
        }
    }
    public void compression(){
        List<Integer>copyValues=new ArrayList<>(values);
        for(int i=0;i<48;i++)
            values.set(i,copyValues.get(PC2[i]-1));
        for(int i=48;i< values.size();i++){
            values.remove(i);
            i--;
        }
    }


    public List<Integer> getValues() {
        return values;
    }
}
