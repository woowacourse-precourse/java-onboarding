package onboarding;

public class Problem4 {

    public static int getNewNum(int idx) {
        if (idx == 32) {
            return idx;
        }
        if (Character.isUpperCase(idx)) {
            return idx + 25 - ((idx - 65) * 2);
        }
        return idx + 25  - ((idx - 97) * 2);
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            answer.append((char)getNewNum(word.charAt(i)));
        }
        return answer.toString();
    }

}
