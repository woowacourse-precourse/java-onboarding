package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int temp;
        char after;

        for(char c : word.toCharArray()) {
            if(c == ' ') answer += " ";

            // UpperCase
            if(Character.isUpperCase(c)) {
                int diff = (char)c - 65;
                temp = (char)90 - diff;
                after = (char)temp;
                answer += after;
            }
            // LowerCase
            else if(Character.isLowerCase(c)) {
                int diff = (char)c - 97;
                temp = (char)122 - diff;
                after = (char)temp;
                answer += after;
            }
        }
        return answer;
    }
}
