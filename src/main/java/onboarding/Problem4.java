package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static boolean exception(String word) {
        if(word.length() < 1 || word.length() > 1000){
            return false;
        }
        return true;
    }
    public static char reverse(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) ('A' + 'Z' - ch);
        }else if (ch >= 'a' && ch <= 'z') {
            return (char) ('a' + 'z' - ch);
        }else{
            return ch;
        }
    }
}
