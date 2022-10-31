package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        if(cryptogram.length() > 1000){
            answer = "Over Length";
            return answer;
        }

        // loop until crypto_check false
        while(crypto_check(cryptogram)) {
            cryptogram = decrypt(cryptogram); // decrypt
        }

        answer = cryptogram;
        return answer;
    }

    private static boolean crypto_check(String cryptogram) {
        if(cryptogram.equals("")) return false;

        // End when duplicate words are found
        for(int i=0; i<cryptogram.length()-1; i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                return true;
            }
        }
        return false;
    }

    private static String decrypt(String cryptogram) {
        String res = "";

        // find and exclude duplicate words
        for(int i=0; i<cryptogram.length()-1; i++) {
            if(cryptogram.charAt(i) != cryptogram.charAt(i+1)){
                res += cryptogram.charAt(i);
            }
            else{
                i += 1;
            }
        }

        // check last word
        if(cryptogram.charAt(cryptogram.length()-2) != cryptogram.charAt(cryptogram.length()-1))
            res += cryptogram.charAt(cryptogram.length()-1);

        return res;
    }
}
