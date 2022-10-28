package onboarding;

public class Problem4 {

    static public boolean isAlphabet(char alphabet) {

        if ('a' <= alphabet && alphabet <= 'z' || 'A' <= alphabet && alphabet <= 'Z')
            return true;

        return false;

    }

    static public char reVerseAlphabet(char in) {

        char out = ' ';

        // a 기준 알파벳의 순번을 이용하여 z부터 거꾸로 내려가는 새로운 순번으로 변환
        // a 는 0번째 이므로 z로 부터 0번째인 z 반환
        // 즉, 기존 순번이 n번 이라면 반환되는 순번은 z로 부터 n번째 전 순환이 반환
        if ('a' <= in && in <= 'z') {
            out = (char) ('z' - (in % 'a'));
        }

        if ('A' <= in && in <= 'Z') {
            out = (char) ('Z' - (in % 'A'));
        }

        return out;
    }

    static public String reverseWord(String word) {

    }


    public static String solution(String word) {
        String answer = "";
        answer = reverseWord(word);
        return answer;
    }

}
