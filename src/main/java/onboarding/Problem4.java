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
    private static String wordConvert(String word){
        String res = "";

        // convert char one by one except blank
        for (int i=0;i<word.length();i++) {
            char cursor = word.charAt(i);
            if (cursor != ' ')
                res += convert(word.charAt(i));
            else
                res += ' ';
        }

        return res;
    }
    public static String solution(String word) {
        String answer = wordConvert(word);
        return answer;
    }
}
