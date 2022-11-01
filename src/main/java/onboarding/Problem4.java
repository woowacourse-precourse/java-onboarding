package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char [] str = word.toCharArray();
        int idx = 0;
        for (char s : str) {
            if (Character.isLetter(s)) {
                str[idx] = convert(s);
            }
            idx++;
        }
        String answer = String.valueOf(str);
        return answer;
    }

    public static char convert(char c) {
        char result = 0;
        if (Character.isUpperCase(c)) {
            result = (char) (155 - c);
        }
        if (Character.isLowerCase(c)) {
            result = (char) (219 - c);
        }
        return result;
    }
}
