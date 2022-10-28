package onboarding;

public class Problem4 {

    static public boolean isAlphabet(char alphabet) {

        if ('a' <= alphabet && alphabet <= 'z' || 'A' <= alphabet && alphabet <= 'Z')
            return true;

        return false;

    }

    static public char reVerseAlphabet(char in) {

        char out = ' ';

        if ('a' <= in && in <= 'z') {
           out = (char)(in - ('a' - 'A'));
        }

        if ('A' <= in && in <= 'Z') {
            out = (char)(in + ('a' - 'A'));
        }

        return out;
    }

    static public char reverseWord(String word) {

        char result = ' ';
        return result;
    }


    public static String solution(String word) {
        String answer = "";
        return answer;
    }

}
