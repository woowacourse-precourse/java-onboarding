package onboarding;

public class Problem2 {

    static final String sampleRegex = "{2,}";
    static String answer = "";

    public static String solution(String cryptogram) {
        boolean flag = true;
        String tmp = cryptogram;

        while(flag) {
            for (int i = 'a'; i <= 'z'; i++) {
                String regex = (char)i + sampleRegex;
                cryptogram = cryptogram.replaceAll(regex, "");
            }

            if (tmp != cryptogram) {    // 무언가 삭제 경우
                tmp = cryptogram;
            } else {                    // 아무것도 삭제하지 않은 경우
                flag = false;
                answer = cryptogram;
            }
        }

        return answer;
    }
}
