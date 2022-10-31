package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = changeString(word);

        return answer;
    }

    private static char changeCase(char c){
        // alphabet인 경우
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return reverseAlphabet(c);
        }
        //not an alphabet
        return c;
    }

    private static char reverseAlphabet(char c){
        // 대문자 순서 바꾸기
        if(c <= 90) {
            return (char) (155 - c);
        }

        // 소문자 순서 바꾸기
        return (char) (219 - c);
    }

    private static String changeString(String word){
        String answer = "";

        for(int i=0;i<word.length();i++){
            answer += changeCase(word.charAt(i));
        }

        return answer;
    }
}
