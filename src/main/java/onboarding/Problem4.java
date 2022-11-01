package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = changeAscii(word);
        return answer;
    }
    public static String changeAscii(String word){
        char[] charArray=charArrays(word);
        String result="";
        for (char text:
             charArray) {
            if (97<=(int)text&&(int)text<=122)
                result+=String.valueOf((char)(219-(int)text));
            else if (65<=(int)text&&(int)text<=90)
                result+=String.valueOf((char)(155-(int)text));
            else result+=String.valueOf(text);
        }

        return result;
    }
    public static char[] charArrays(String text){
        char[] charArray = text.toCharArray();
        return charArray;
    }
}
