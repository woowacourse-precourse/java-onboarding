package onboarding;

public class Problem4 {
    private static char changeUpper(char x){
        return (char) (x+25-(x-'A')*2);
    }
    private static char changeLower(char x){
        return (char) (x+25-(x-'a')*2);
    }
    public static String solution(String word) {
        String answer = "";
        for (char x : word.toCharArray()){
            if(Character.isUpperCase(x))
                answer +=changeUpper(x);
            else if(Character.isLowerCase(x))
                answer +=changeLower(x);
            else
                answer +=x;
        }
        return answer;
    }
}
