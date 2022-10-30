package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='a'&&word.charAt(i)<='z'){
               answer.append((char)('z' - word.charAt(i) + 'a'));
            }
            else if( word.charAt(i)>='A'&&word.charAt(i)<='Z'){
                answer.append((char)('Z' - word.charAt(i) + 'A'));
            }
            else{
                answer.append(word.charAt(i));
            }
        }
        return answer.toString();
    }
}
