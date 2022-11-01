package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            char tmep = ch;

            if ('A' <= ch && ch <= 'Z')
                tmep = (char) ('Z' - ch + 'A');
            else if ('a' <= ch && ch <= 'z')
                tmep = (char) ('z' - ch + 'a');

            answer += tmep;
        }
        return answer;
    }
}

