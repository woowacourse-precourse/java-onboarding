package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 1. 암호문을 복호화 한다.
        return decode(cryptogram);
    }

    public static String decode(String cryptogram) {
        String pattern = "(([a-z])\\2{1,})";
        // 문자에서 반복되는 문자가 있을 경우 모두 삭제
        String decryptogram = cryptogram.replaceAll(pattern, "");

        // 만약 반복되는 문자열이 없다면 복호화 완료
        if (decryptogram.equals(cryptogram)) {
            return decryptogram;
        }
        // 복호화가 되었다면 다시 복호화를 진행해야 한다.
        return decode(decryptogram);
    }


}
