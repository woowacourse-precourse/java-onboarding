package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = getConvertedWord(word);
        return answer;
    }

    public static String getConvertedWord(String word) {
        StringBuilder sb = new StringBuilder();
        int len = word.length();

        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)(155 - ch));
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char)(219 - ch));
                continue;
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}
