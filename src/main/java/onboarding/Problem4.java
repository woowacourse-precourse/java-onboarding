package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0; i<word.length(); i++){
            if(65 <= word.charAt(i) && word.charAt(i) <= 90){
                answer += (char)('Z' - (word.charAt(i) - 'A'));
            }else if(97 <= word.charAt(i) && word.charAt(i) <= 122){
                answer += (char)('z' - (word.charAt(i) - 'a'));
            }else{
                answer += " ";
            }
        }
        return answer;
    }
}
