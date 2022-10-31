package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    static String decrypt(String crypt){
        List<Boolean> is_removable = new ArrayList<>();
        StringBuilder ret_value = new StringBuilder();
        for(int i = 0; i <crypt.length(); i++){
            is_removable.add(false);
        }

        for(int i = 0; i < crypt.length()-1; i++){
            if(crypt.charAt(i) == crypt.charAt(i+1)){
                is_removable.set(i, true);
                is_removable.set(i+1, true);
            }
        }

        for(int i = 0; i < crypt.length(); i++) {
            if(!is_removable.get(i)){
                ret_value.append(crypt.charAt(i));
            }

        }
        return ret_value.toString();
    }

    static String decryption(String cryptogram){
        String tmp_decrypto = decrypt(cryptogram);
        if(cryptogram.equals(tmp_decrypto) || tmp_decrypto.length() == 0){
            return tmp_decrypto;
        }
        return decryption(tmp_decrypto);
    }

    public static String solution(String cryptogram) {
        return decryption(cryptogram);
    }
}
