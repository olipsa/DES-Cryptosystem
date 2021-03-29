import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        //Encryption
        Plaintext plaintext=new Plaintext();
        System.out.println("The plaintext is:     "+plaintext.getValues());
        plaintext.initialPermutation();
        SplitPlainText left=new SplitPlainText();
        SplitPlainText right=new SplitPlainText();
        plaintext.divide(left,right);
        Key key=new Key();
        Key copyKey=new Key(key);
        key.dropParityBits();
        copyKey.dropParityBits();

        for(int i=0;i<16;i++){
            feistelFunction(left, right, key, i);

        }
        Ciphertext ciphertext=new Ciphertext(right.getValues(),left.getValues());

        //Decryption
        plaintext.clear();
        left.clear();right.clear();
        ciphertext.initialPermutation();
        ciphertext.divide(left,right);
        for(int i=15;i>=0;i--){
            feistelFunction(left, right, copyKey, i);
        }

        Ciphertext currentPlaintext=new Ciphertext(right.getValues(),left.getValues());
        System.out.println("Decrypted ciphertext: "+currentPlaintext.getValues());




    }

    private static void feistelFunction(SplitPlainText left, SplitPlainText right, Key copyKey, int i) {
        List<Integer> copyRPT=new ArrayList<>(right.getValues());
        copyKey.bitsRotation(i);
        copyKey.compression();
        right.expand();
        Sbox sboxSubstitution=new Sbox(right.XOR(copyKey.getValues()));
        sboxSubstitution.substitute();
        Pbox pbox=new Pbox(sboxSubstitution.getOutputBlock());
        right.replace(left.XOR(pbox.getPermutation()));
        left.replace(copyRPT);
    }
}
