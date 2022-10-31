package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);

            if (97 <= ascii && ascii <= 122) {
                ascii += 25 - 2*(ascii-97);
            }
            else if (65 <= ascii && ascii <= 90)
            {
                ascii += 25 - 2*(ascii-65);
            }

            answer += (char) ascii;
        }

        return answer;
    }
}
