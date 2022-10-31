package onboarding;

public class Problem4 {
    // func : get char and switch char
    private static char convert(char c){

        // convert char to int (ascii)
        int cNum = (int) c;
        int res;
        // if c is upper case
        if (Character.isUpperCase(c))
            res = (int)'Z' - (cNum - (int)'A');
        else
            res = (int)'z' - (cNum - (int)'a');

        return (char)res;
    }
    // func : get string and convert string
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
