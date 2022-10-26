package onboarding;

public class Problem4 {
    //A - Z : 65-90
    //a-z : 97-122
    public static String solution(String word) {
        String answer = "";

        for(char x : word.toCharArray()){
            if (Character.isAlphabetic(x)) {
                if (Character.isUpperCase(x)) answer += (char)(155-x);
                else answer += (char)(219-x);
            }
            else answer+=x;
        }

        return answer;
    }
}
