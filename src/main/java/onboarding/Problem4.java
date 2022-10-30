package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++){
            int ascii = word.charAt(i);

            if(65 <= ascii && ascii <= 90){
                answer += String.valueOf((char)((90 - ascii) + 65));

            }else if(97 <= ascii && ascii <= 122){
                answer += String.valueOf((char)((122 - ascii) + 97));

            }else{
                answer += String.valueOf(word.charAt(i));

            }
        }
        return answer;
    }
}
