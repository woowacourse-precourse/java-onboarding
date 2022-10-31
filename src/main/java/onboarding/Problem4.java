package onboarding;

public class Problem4 {
    private static final String Upper = "ABCDEFGHIJKLMNOPQRSTUVWSYZ";
    private static final String Lower = "abcdefghijklmnopqrstuvwsyz";

    public static String solution(String word) {
        String answer = "";

        for(int i=0; i<word.length(); i++){
            answer += check_change(word.charAt(i));
        }
        return answer;
    }

    private static char check_change(char word) {
        char res;

        if(word >='A' && word <= 'Z') {
            res = Upper.charAt(25 - Upper.indexOf(word));
            return res;
        }
        else if(word >= 'a' && word <= 'z') {
            res = Lower.charAt(25 - Lower.indexOf(word));
            return res;
        }
        else {
            return word;
        }
    }
}
