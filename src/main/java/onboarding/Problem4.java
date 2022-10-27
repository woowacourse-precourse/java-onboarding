package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char reverseBig(char chr){
        int offset = 'Z' - chr;

        return (char)('A'+offset);
    }

    public static  char reverseSmall(char chr){
        int offset = 'z' - chr;

        return (char)('a'+offset);
    }


}
