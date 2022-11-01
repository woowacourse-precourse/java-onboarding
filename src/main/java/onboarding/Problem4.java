package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch))
                answer += isUpperAlpha(ch);
            else if(Character.isLowerCase(ch))
                answer += isLowerAlpha(ch);
            else
                answer += ch;
        }

        return answer;
    }

    public static char isUpperAlpha(char ch){
        return (char)(90 -(ch - 65));
    }

    public static char isLowerAlpha(char ch){
        return (char)(122 -(ch - 97));
    }
}
