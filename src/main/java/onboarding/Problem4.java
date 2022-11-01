package onboarding;

public class Problem4 {
    private static char chWord(char c){
        if((int)c >= 65 && (int)c < 91)
            return (char)(155 - (int)c);

        else if((int)c >= 97 && (int)c < 123)
            return (char) (219 - (int) c);
        return c;
    }
    public static String solution(String word){
        String answer = "";

        for(char c : word.toCharArray()){
            answer += chWord(c);
        }
        return answer;
    }
}
