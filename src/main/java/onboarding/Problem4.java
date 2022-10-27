package onboarding;

public class Problem4 {
    /**
     * 청개구리 사전
     */
    public static char[] dic = {
            'Z', 'Y', 'X', 'W', 'V', 'U',
            'T', 'S', 'R', 'Q', 'P', 'O',
            'N', 'M', 'L', 'K', 'J', 'I',
            'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

    /**
     * 청개구리언어 치환 메서드
     * @param w 치환할 문자
     * @return 치환된 문자
     */
    public static char changeWord(char w) {
        if (Character.isUpperCase(w)) {
            w = dic[w - 65];
            return w;
        }
        if (Character.isLowerCase(w)) {
            w = (char)(dic[w - 97] + 32);
            return w;
        }
        return w;
    }
    public static String solution(String word) {
        String answer = "";
        for (char w : word.toCharArray()) {
            answer += changeWord(w);
        }
        return answer;
    }
}
