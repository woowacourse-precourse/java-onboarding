package onboarding;

public class Problem2 {
    // 전체 기능 호출
    public static String solution(String cryptogram) {
        return decryption(cryptogram);
    }
    // 문자열 암호해독 메서드
    private static String decryption(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        char[] splitCryptogram = cryptogram.toCharArray();
        boolean[] isReduplication = new boolean[splitCryptogram.length];
        int reduplicationCount = 0;

        return "";
    }
}
