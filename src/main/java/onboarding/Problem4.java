package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        return answer;
    }
    public static char change(char c){
        char result = c;
        if (c>=65 && c<=90){
            int temp = c - 65;
            result = (char) (90-temp);
        } else if (c >= 97 && c<=122) {
            int temp = c - 97;
            result = (char) (122-temp);
        }
        return result;
    }

}
