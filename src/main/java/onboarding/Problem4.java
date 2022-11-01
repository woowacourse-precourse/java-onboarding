package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i=0; i<word.length(); i++){
                answer += reverseWord(word.charAt(i));
        }
        return answer;
    }

    //1. 입력된 char가 알파벳인 경우 뒤집어서 반환하는 기능(reverseWord)
    private static char reverseWord(char c){
        if ('A'<=c && c<='Z'){
            return (char)('Z'-(c-'A'));
        } else if ('a'<=c && c<='z'){
            return (char)('z'-(c-'a'));
        } else {
            return c;
        }
    }
}
