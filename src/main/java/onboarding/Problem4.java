package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<word.length();i++){
            int asciiWord = word.charAt(i);
            //알파벳의 경우
            getAnswer(word, answer, i, asciiWord);
        }
        return answer.toString();
    }
}
