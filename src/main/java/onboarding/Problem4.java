package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(char x : word.toCharArray()){
            if (Character.isAlphabetic(x))
                answer += Character.isUpperCase(x) ? (char)(155-x) :(char)(219-x);
            else
                answer+=x;
        }

        return answer;
    }
}
