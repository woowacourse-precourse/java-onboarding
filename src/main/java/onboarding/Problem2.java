package onboarding;

public class Problem2 {

    static private final String BLANK = "";
    static private final String SAMPLE_REGEX = "{2,}";
    static private String answer = "";

    public static String solution(String cryptogram) {
        boolean flag = true;
        String beforeCryptogram = cryptogram;

        while(flag) {
            cryptogram = decrypt(cryptogram);

            if (beforeCryptogram != cryptogram) {   // 중복을 삭제한 경우
                beforeCryptogram = cryptogram;
            } else {                                // 중복이 없는 경우
                answer = cryptogram;
                flag = false;
            }
        }

        return answer;
    }

    public static String decrypt(String cryptogram) {
        for (int i = 'a'; i <= 'z'; i++) {
            String regex = (char)i + SAMPLE_REGEX;
            cryptogram = cryptogram.replaceAll(regex, BLANK);
        }

        return cryptogram;
    }
}
