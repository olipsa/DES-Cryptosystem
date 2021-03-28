import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        //Encryption
        Plaintext plaintext=new Plaintext();
        System.out.println(plaintext.getValues());
        plaintext.initialPermutation();
        SplitPlainText left=new SplitPlainText();
        SplitPlainText right=new SplitPlainText();
        plaintext.divide(left,right);
        Key key=new Key();
        System.out.println(key.getValues());
        key.dropParityBits();

        for(int i=0;i<16;i++){
            List<Integer> copyRPT=new ArrayList<>(right.getValues());
            key.bitsRotation(i);
            key.compression();
            right.expand();
            Sbox SboxSubstitution=new Sbox(right.XOR(key.getValues()));
            SboxSubstitution.substitute();
            Pbox Pbox=new Pbox(SboxSubstitution.getOutputBlock());
            right.replace(left.XOR(Pbox.getPermutation()));
            left.replace(copyRPT);

        }
        Ciphertext ciphertext=new Ciphertext(left.getValues(),right.getValues());
        System.out.println(ciphertext.getValues());

        //Decryption
        plaintext.clear();
        left.clear();right.clear();
        ciphertext.divide(left,right);



    }
}
