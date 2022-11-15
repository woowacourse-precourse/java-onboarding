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

            if (isRemoveDuplication(beforeCryptogram, cryptogram)) {
                beforeCryptogram = cryptogram;
                continue;
            }

            answer = cryptogram;
            flag = false;
        }

        return answer;
    }

    public static boolean isRemoveDuplication(String beforeCryptogram, String cryptogram) {
        return beforeCryptogram != cryptogram;
    }

    public static String decrypt(String cryptogram) {
        for (int alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            String regex = (char)alphabet + SAMPLE_REGEX;
            cryptogram = cryptogram.replaceAll(regex, BLANK);
        }

        return cryptogram;
    }
}
