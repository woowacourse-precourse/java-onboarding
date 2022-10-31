package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if(isValid(cryptogram))
            return delDuplicate(cryptogram);
        else
            return "";
    }

    static String delDuplicate(String cryptogram){
        String regex;
        String del_regex;
        String decode = "";

        for (char c : cryptogram.toCharArray()) {
            regex = String.format(".*[%c]{2}.*", c); // 연속된 문자를 찾는 정규표현식
            del_regex = String.format("[%c]{2}", c); // 연속된 문자를 제거하는 정규표현식

            if (cryptogram.matches(regex)) {
                decode = cryptogram.replaceAll(del_regex, "");
                break;
            } else {
                decode = cryptogram;
            }
        }
        if (decode.length() == cryptogram.length()) { // 연속된 문자가 없다면
            return decode;
        } else {
            return delDuplicate(decode);
        }
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



