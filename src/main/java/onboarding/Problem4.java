package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int ascii = 0;
        char[] tempArr = word.toCharArray();
        for (int i = 0; i < tempArr.length; i++) {
            ascii = setAsciiOfAlphabet(tempArr[i]);
        }
        return answer;
    }
    public static int setAsciiOfAlphabet(char c){
        int ascii = 0;
        if(Character.isUpperCase(c)) ascii = 65;
        else if (Character.isLowerCase(c)) ascii = 97;
        return ascii;
    }
}
