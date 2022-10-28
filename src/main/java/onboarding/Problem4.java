package onboarding;

public class Problem4 {
    private static void checkWord(String word) {
        if (word.length() > 1000 || word.length() < 1)
            throw new IllegalArgumentException("올바른 범위의 입력값이 아닙니다.");
    }

    private static char convert(char c){
        if(c>=65&&c<=90)
            return (char)(90-c+65);
        if(c>=97&&c<=122)
            return (char)(122-c+97);
        return c;
    }

    public static String solution(String word) {
        checkWord(word);
        String answer = "";
        return answer;
    }
}
