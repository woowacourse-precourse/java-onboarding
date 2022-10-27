package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int upper = (int)'A' + (int)'Z';
        int lower = (int)'a' + (int)'z';
        String answer = "";

        for(char c: word.toCharArray()){
            if(Character.isUpperCase(c)) answer += (char)(upper-(int)c);
            else if(Character.isLowerCase(c)) answer += (char)(lower-(int)c);
            else answer += c;
        }
        return answer;
    }
}
