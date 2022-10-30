package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0; i<word.length(); i++){
            char cur = word.charAt(i);

            if (cur>='a' && cur <= 'z'){    // a - z 경우
                cur = (char) ('z' - (cur - 'a'));
            }
            else if (cur>='A' && cur <= 'Z'){   // A - Z 경우
                cur = (char) ('Z' - (cur - 'A'));
            }
            answer+=cur;
        }

        return answer;
    }
}
