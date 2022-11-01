package onboarding;

import onboarding.problem2.Cryptogram;

public class Problem2 {

    public static String solution(String cryptogram) {

        while(cryptogram.length() > 0){
            String decodeResult = Cryptogram.removeDuplicateCharacters(cryptogram);
            if(decodeResult.equals(cryptogram))
                break;

            cryptogram = decodeResult;
        }

        return cryptogram;
    }
}