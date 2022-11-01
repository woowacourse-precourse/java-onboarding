package onboarding;

/**
 * isProperCryptogram 메서드 암호문이 적절한지 확인
 * getDecodingCryptogram 메서드 해독된 암호문을 반환
 * isLengthZero 암호문의 길이가 0인지 확인
 * isDecodingCryptogram 암호해독이 완료됐는지 확인
 * deleteOverlap 중복된 문자열을 제거 하여 반
 */
public class Problem2 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final String LOWERCASE = "^[a-z]*$";

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static void isProperCryptogram(String cryptogram) {
        if (cryptogram.length() < MIN_LENGTH || cryptogram.length() > MAX_LENGTH)
            throw new IllegalArgumentException("cryptogram의 길이는 1이상 1000이하인 문자열입니다.");
        if (!cryptogram.matches(LOWERCASE))
            throw new IllegalArgumentException("cryptogram은 소문자로만 이루어져 있어야합니다.");
    }

    private static boolean isLengthZero(String cryptogram) {
        return cryptogram.length() == 0 ? true : false;
    }

}
