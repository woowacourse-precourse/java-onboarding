package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        if(!isAlphabet(cryptogram) || !isLowerAlphabet(cryptogram) || !isOutOfRange(cryptogram)) {
            return "";
        }

        return answer;
    }

    // validtaion 순서 : 범위에 맞는지 -> 문자열인지 -> 대소문자인지

    private static boolean isAlphabet(String cryptogram) {
        boolean result = true;
        for (int i = 0; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) < 'a' || cryptogram.charAt(i) > 'z'){
                result = false;
            }
        }
        return result;
    }

    private static boolean isLowerAlphabet(String cryptogram) {
        String modified = cryptogram.toLowerCase();
        return cryptogram.equals(modified); // lower로 바꾼 후 같다면 변화된 것이므로 false 를 return 한다.
    }

    private static boolean isOutOfRange(String cryptogram) {
        return cryptogram.length() >= 1 && cryptogram.length() <= 4000;
    }
}
