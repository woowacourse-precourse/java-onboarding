package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        String crypto_str = cryptogram;
        while(true) {
            if(check(crypto_str)) {
                crypto_str = decryption(crypto_str);
            } else {
                break;
            }
        }
        answer = crypto_str;

        return answer;
    }

    /***
     * 중복 문자 여부 확인
     * @param cryptogram
     * @return
     */
    private static boolean check(String cryptogram) {
        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    /***
     * 중복 문자 제거
     * - 같은 문자가 연속되는 경우, 해당 문자들을 제거한다.
     * @param cryptogram
     * @return
     */
    private static String decryption(String cryptogram) {
        String decrypto_str = "";
        int i = 0;
        for (; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                int count = 0;
                for (int j = i; j < cryptogram.length() - 1; j++) {
                    if (cryptogram.charAt(j) == cryptogram.charAt(j + 1)) count++;
                    else break;
                }
                i += count;
            } else {
                decrypto_str += cryptogram.charAt(i);
            }
        }
        if(i == cryptogram.length()-1) {
            decrypto_str += cryptogram.charAt(i);
        }

        return decrypto_str;
    }
}
