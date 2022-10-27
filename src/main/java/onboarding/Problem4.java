package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch > 'a' && ch < 'z'){
                ch = (char) ('z'-(ch-'a'));
            }
            if(ch > 'A' && ch < 'Z'){
                ch = (char) ('Z'-(ch-'A'));
            }
            answer += ch;
        }
        return answer;
    }
}
