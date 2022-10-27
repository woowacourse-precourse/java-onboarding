package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = checkCryptogram(cryptogram);
        return answer;
    }
    public static String checkCryptogram(String cryptogram) {

        String crypto = cryptogram;

        while(true){

            int crypto_len = crypto.length();

            if (crypto_len <= 1) {
                return crypto; // 문자열 길이가 1 이다.
            } else if (crypto_len == 2)
            {
                if (crypto.charAt(0) == crypto.charAt(1))
                {
                    return "";
                }
                else {
                    return crypto;
                }
            }else {
                crypto = removeCrypto(crypto);
                if(!checkLeft(crypto)){
                    // 전부 다른 경우
                    return crypto ;
                };

            }
        }
    }

    // cryto의 길이가 3 이상인 경우만을 처리합니다. // 단 한 번만 줄여서 반환 합니다

    /**
     *
     * @param crypto which length is over 3
     * @return cryto 연속 중복이 제거된 crypto
     */
    public static  String removeCrypto(String crypto){
        /// sub string () -> index 로 접근
        String[] al = crypto.split("");
        int n = al.length;
        int[] check_list =  new int[n];
        List<String> result = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (al[i - 1].equals(al[i])) {
                check_list[i-1] = 1;
                check_list[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (check_list[i] == 0 ){
                result.add(al[i]);
            }
        }

        if(result.isEmpty()){
            return "";
        }
        else {
            return String.join("", result);
        }
    }

    // checkSame char

    /**
     *
     * @param cryptogram Stirng  after removeCrypto
     * @return boolean true case String length is under 3   or have same char in String
     */
    public static  Boolean checkLeft(String cryptogram){

        if (cryptogram.length() <= 2) {return  true;}
        //중복 문자열이 있으면 true 를 반환
        String[] al = cryptogram.split("");

        for (int i = 1; i < al.length; i++) {
            if (al[i - 1].equals(al[i])) {
                return true;
            }

        }
        // 남은 문자열의 내용이 전부 다른 경우
        return false;
    }
}

