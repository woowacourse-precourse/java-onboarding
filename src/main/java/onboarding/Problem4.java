package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i< word.length(); i++){
            if(((int)word.charAt(i) > 96) && (int)word.charAt(i) < 123){
                answer += (char)(122 - (int)word.charAt(i) + 'a');
            }else if (((int)word.charAt(i) > 64) && (int)word.charAt(i) < 91){
                answer += (char)(90 - (int)word.charAt(i) + 'A');
            }else{
                answer += word.charAt(i);
            }
        }
        return answer;
    }
}

