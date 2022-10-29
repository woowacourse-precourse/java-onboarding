package onboarding;

public class Problem4 {

    // 대문자일 경우 M=77, 소문자일 경우 m=122를 기준으로 설정
    public static String reverseChar(int ascii, int criterion) {
        String res;
        int gap = Math.abs(ascii-criterion);

        if (ascii > criterion) {
            ascii = ascii-gap-(gap-1);
        }
        else {
            ascii = ascii+gap+(gap+1);
        }

        res = Character.toString((char)ascii);

        return res;
    }

    public static String checkReverse(char ch) {
        String res;

        int ascii = (int)ch;

        // 대문자일 경우
        if (ascii >= 65 && ascii <= 90) {
            res = reverseChar(ascii, 77);
        }
        // 소문자일 경우
        else if (ascii >= 97 && ascii <= 122) {
            res = reverseChar(ascii, 109);
        }
        // 문자가 아닐 경우
        else {
            res = Character.toString(ch);
        }

        return res;
    }
    public static String solution(String word) {
        String answer = "";
        int wordLen = word.length();
        char tmp;

        for (int i = 0; i < wordLen; i++) {
            tmp = word.charAt(i);
            answer += checkReverse(tmp);
        }

        return answer;
    }
}
