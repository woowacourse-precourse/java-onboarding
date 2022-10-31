package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    static boolean isValid(String cryptogram){
        int min_length = 1;
        int max_length = 1000;
        int crypto_length = cryptogram.length();
        // 예외 1. 문자열 길이가 주어진 범위를 벗어났을때
        if(crypto_length < min_length || crypto_length > max_length)
            return false;
        // 예외 2. 대문자가 포함되어있을때
        else return cryptogram.toLowerCase().equals(cryptogram);
    }
}



