package onboarding;

public class Problem4 {

    private final static int  UPPER_CASE_SUM = 155;
    private final static int  LOWER_CASE_SUM = 219;

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    private static char changeUppercase(int c){
        char reverse_Word = (char)(UPPER_CASE_SUM - c);
        return reverse_Word;
    }

    private static char changeLowercase(int c){
        char reverse_Word = (char)(LOWER_CASE_SUM - c);
        return reverse_Word;
    }
}
