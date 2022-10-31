package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

for (int i = 0; i < word.length(); i++) {
            if (('A' <= word.charAt(i)) && (word.charAt(i) <= 'Z')) {
                answer += (char)('Z' - word.charAt(i) + 'A');
            }
            else if (('a' <= word.charAt(i)) && (word.charAt(i) <= 'z')) {
                answer += (char)('z' - word.charAt(i) + 'a');
            }
            else {
                answer += word.charAt(i);
            }
        }


        return answer;
    }
}
