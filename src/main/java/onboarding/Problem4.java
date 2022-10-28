package onboarding;

public class Problem4 {
    public static void checkWord(String word){
        if(word.length()>1000||word.length()<1)
            throw new IllegalArgumentException("올바른 범위의 입력값이 아닙니다.");
    }
    public static String solution(String word) {
        checkWord(word);
        String answer = "";
        return answer;
    }
}
