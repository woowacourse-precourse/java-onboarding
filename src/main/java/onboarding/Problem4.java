package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='a'&&word.charAt(i)<='z'){
               answer.append('z' - word.charAt(i) + 'a');
            }
        }
        return answer.toString();
    }
}
