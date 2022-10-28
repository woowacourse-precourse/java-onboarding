package onboarding;

public class Problem2 {

    static final String sampleRegex = "{2,}";
    static String answer = "";

    public static String solution(String cryptogram) {
        boolean flag = true;
        String tmp = cryptogram;

        while(flag) {
            cryptogram = decrypt(cryptogram);

            if (tmp != cryptogram) {    // 중복을 삭제한 경우
                tmp = cryptogram;
            } else {                    // 중복이 없는 경우
                answer = cryptogram;
                flag = false;
            }
        }

        return answer;
    }

    public static String decrypt(String cryptogram) {
        for (int i = 'a'; i <= 'z'; i++) {
            String regex = (char)i + sampleRegex;
            cryptogram = cryptogram.replaceAll(regex, "");
        }

        return cryptogram;
    }
}
