package onboarding;

public class Problem2 {

    public static void main(String[] args) {
        String testStr = "browoanoommnaon";

        solution(testStr);
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        String cryptoCleared = "";
        boolean flagDupli = true;
        int idxCrypto = 0;

        for(int i = idxCrypto; i < cryptogram.length(); i++) {
            if(i+1 == cryptogram.length()) {
                cryptoCleared += cryptogram.charAt(i);
                break;
            }

            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                for(int j = i+1; j < cryptogram.length(); j++) {
                    if(cryptogram.charAt(i) != cryptogram.charAt(j)) {
                        //System.out.println(j);
                        i = j-1;
                        break;
                    }
                }
            }
            else {
                cryptoCleared += cryptogram.charAt(i);
            }
        }

        System.out.println(cryptoCleared);

        return answer;
    }
}
