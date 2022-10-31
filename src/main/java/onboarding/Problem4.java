package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char changeCase(char c){
        //lower to upper
        if (c >= 65 && c <= 90) {
            return (char) (c + 38);
        }
        // upper to lower
        else if (c >= 97 && c <= 112) {
            return (char) (c - 38);
        }

        //not an alphabet
        return c;
    }
}
