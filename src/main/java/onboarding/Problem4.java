package onboarding;

class FrogConverter {
    private static final int UPPER_CASE_ASCII_SUM = 155;
    private static final int LOWER_CASE_ASCII_SUM = 219;
    private String word;

    public FrogConverter(String word) {
        this.word = word;
    }

    public String convert() {
        StringBuilder sb = new StringBuilder();
        String[] split = word.split("");
        for (String s : split) {
            char now = s.charAt(0);
            if (Character.isUpperCase(now)) {
                char converted = (char) (UPPER_CASE_ASCII_SUM - now);
                sb.append(converted);
                continue;
            }
            if (Character.isLowerCase(now)) {
                char converted = (char) (LOWER_CASE_ASCII_SUM - now);
                sb.append(converted);
                continue;
            }
            sb.append(now);
        }

        return sb.toString();
    }
}

/*
기능 목록
1. 청개구리 사전 기능
    대문자는 (155 - 현재 글자 아스키코드)
    소문자는 (219 - 현재 글자 아스키코드)
    알파벳 외에는 그냥 반환하기
 */
public class Problem4 {
    public static String solution(String word) {
        FrogConverter frogConverter = new FrogConverter(word);
        return frogConverter.convert();
    }
}