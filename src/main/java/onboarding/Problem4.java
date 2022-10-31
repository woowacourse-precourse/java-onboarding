package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(char c : word.toCharArray()) {
            if(Character.isAlphabetic(c))
                sb.append(reverse_char(c));

            else sb.append(c);
        }

        answer = sb.toString();
        return answer;
    }
}
