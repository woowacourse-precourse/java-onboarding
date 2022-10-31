package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        // 한 글자씩 접근해 청개구리 사전대로 변환
        for (char ch : word.toCharArray()) {
            answer.append(getConvertedChar(ch));
        }

        return answer.toString();
    }

    public static char getConvertedChar(char ch) {
        if (ch >= 'A' && ch <= 'M') return (char) ('N' + Math.abs(ch - 'M'));
        else if (ch >= 'N' && ch <= 'Z') return (char) ('M' - Math.abs(ch - 'N'));
        else if (ch >= 'a' && ch <= 'm') return (char) ('n' + Math.abs(ch - 'm'));
        else if (ch >= 'n' && ch <= 'z') return (char) ('m' - Math.abs(ch - 'n'));
        return ch;
    }
}
