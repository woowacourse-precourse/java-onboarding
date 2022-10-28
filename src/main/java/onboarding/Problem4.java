package onboarding;

public class Problem4 {
    public static char reverseWord(char c) {
        if (c >= 'A' && c <= 'Z')
            return (char) ('Z' - c + 'A');
        else if (c >= 'a' && c <= 'z')
            return (char) ('z' - c + 'a');
        else
            return c;

    }

    public static String solution(String word) {
        String answer = "";

        char [] tmp=word.toCharArray();

        for(int i=0;i<tmp.length;i++){
            answer+=reverseWord(tmp[i]);
        }

        return answer;
    }
}
