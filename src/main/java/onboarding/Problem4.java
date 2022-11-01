package onboarding;

public class  Problem4 {
    public static String solution(String word) {
        int i = word.length();
        char[] chars = word.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(char c : chars) {
            sb.append(changeWord(c));
        }

        return sb.toString();
    }

    static char changeWord(char c) {
        // 대문자일 경우
        if(c >= 65 && c <= 90) {
            return (char)(155 - c);
        }

        // 소문자일 경우
        if(c >= 97 && c <= 122) {
            return (char) (219 - c);
        }

        return c;
    }
}
