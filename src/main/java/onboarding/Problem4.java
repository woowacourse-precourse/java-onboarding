package onboarding;

public class Problem4 {
    public static char convertWord(char word) {
        if (Character.isUpperCase(word)) return (char) ('A'+'Z'-word);         //대문자인 경우 변경
        else if (Character.isLowerCase(word)) return (char) ('a'+'z'-word);    //소문자인 경우 변경
        return word;
    }
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<word.length(); i++) {
            char current = word.charAt(i);  //i번째 index 배열 접근이 많으므로 변수로 선언
            answer.append(convertWord(current));
        }
        return answer.toString();
    }
}
