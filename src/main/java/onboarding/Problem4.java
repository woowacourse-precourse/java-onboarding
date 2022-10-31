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
    private static char reverse_char(char c) {
        int tmp = 0;

        if(Character.isLowerCase(c)) {
            tmp = c - 97;
            return (char)(122 - tmp);
        }

        else{
            tmp = c - 65;
            return (char)(90 - tmp);
        }
    }

}
